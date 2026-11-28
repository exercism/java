package exercism.testgenerator.service;

import com.fasterxml.jackson.databind.JsonNode;
import exercism.testgenerator.model.CanonicalCase;
import exercism.testgenerator.model.CanonicalData;
import exercism.testgenerator.model.ExerciseConfig;
import exercism.testgenerator.model.RenderedExercise;
import exercism.testgenerator.model.RenderedTestCase;
import exercism.testgenerator.model.TestCaseConfig;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExerciseTestGenerator {

    private final ProblemSpecService problemSpecService;
    private final TestsTomlService testsTomlService;
    private final ExerciseConfigService exerciseConfigService;
    private final CaseFlattener caseFlattener;
    private final TemplateRenderer templateRenderer;

    public ExerciseTestGenerator() {
        this(
            new ProblemSpecService(),
            new TestsTomlService(),
            new ExerciseConfigService(),
            new CaseFlattener(),
            new TemplateRenderer()
        );
    }

    public ExerciseTestGenerator(
        ProblemSpecService problemSpecService,
        TestsTomlService testsTomlService,
        ExerciseConfigService exerciseConfigService,
        CaseFlattener caseFlattener,
        TemplateRenderer templateRenderer
    ) {
        this.problemSpecService = problemSpecService;
        this.testsTomlService = testsTomlService;
        this.exerciseConfigService = exerciseConfigService;
        this.caseFlattener = caseFlattener;
        this.templateRenderer = templateRenderer;
    }

    public GenerationResult generate(Path exerciseDirectory) throws IOException, InterruptedException {
        String slug = exerciseDirectory.getFileName().toString();
        Path metaDir = exerciseDirectory.resolve(".meta");
        Path configPath = metaDir.resolve("config.json");
        Path testsTomlPath = metaDir.resolve("tests.toml");

        ExerciseConfig config = exerciseConfigService.parseConfig(configPath);
        Map<String, TestCaseConfig> tomlConfigs = testsTomlService.parseTestsToml(testsTomlPath);

        CanonicalData canonicalData = problemSpecService.fetchCanonicalData(slug);
        List<CanonicalCase> allCases = caseFlattener.flatten(canonicalData.cases());

        List<CanonicalCase> activeCases = allCases.stream()
            .filter(c -> testsTomlService.isCaseIncluded(tomlConfigs, c.uuid()))
            .toList();

        Path targetTestPath = exerciseDirectory.resolve(config.getTestFilePath());
        if (activeCases.isEmpty()) {
            return new GenerationResult(slug, targetTestPath, null, 0, allCases.size());
        }

        String testClassName = config.getTestClassName();
        if (testClassName == null || testClassName.isBlank()) {
            testClassName = JavaNamingHelper.toPascalCase(slug) + "Test";
        }

        String solutionClassName = config.getSolutionClassName();
        if (solutionClassName == null || solutionClassName.isBlank()) {
            solutionClassName = JavaNamingHelper.toPascalCase(slug);
        }

        List<RenderedTestCase> renderedCases = new ArrayList<>();
        boolean hasExceptions = false;
        boolean hasFloatingPoint = false;
        boolean hasList = false;
        boolean hasMap = false;
        boolean hasSet = false;
        Map<String, Integer> methodNameCounts = new LinkedHashMap<>();

        for (int i = 0; i < activeCases.size(); i++) {
            CanonicalCase c = activeCases.get(i);
            boolean disabled = (i > 0);

            String baseMethodName = JavaNamingHelper.toMethodName(c.description());
            int count = methodNameCounts.getOrDefault(baseMethodName, 0) + 1;
            methodNameCounts.put(baseMethodName, count);
            String methodName = (count == 1) ? baseMethodName : baseMethodName + count;
            Map<String, String> formattedInputs = new LinkedHashMap<>();
            Map<String, JsonNode> inputNodes = new LinkedHashMap<>();
            List<String> rawArgValues = new ArrayList<>();

            if (c.input() != null && c.input().isObject()) {
                Iterator<Map.Entry<String, JsonNode>> fields = c.input().fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> field = fields.next();
                    String formatted = JavaTypeFormatter.format(field.getValue());
                    formattedInputs.put(field.getKey(), formatted);
                    inputNodes.put(field.getKey(), field.getValue());
                    rawArgValues.add(formatted);
                }
            } else if (c.input() != null) {
                String formatted = JavaTypeFormatter.format(c.input());
                formattedInputs.put("input", formatted);
                inputNodes.put("input", c.input());
                rawArgValues.add(formatted);
            }

            String property = c.property() != null ? c.property() : "run";
            String singleLineArgs = String.join(", ", rawArgValues);
            String invocationCode;
            if (singleLineArgs.length() > 60 && rawArgValues.size() > 1) {
                invocationCode = "new " + solutionClassName + "()." + property + "(\n"
                    + "                        " + String.join(",\n                        ", rawArgValues)
                    + "\n                )";
            } else {
                invocationCode = "new " + solutionClassName + "()." + property + "(" + singleLineArgs + ")";
            }

            boolean expectedError = c.isErrorExpected();
            String expectedException = expectedError ? "IllegalArgumentException" : null;
            String expectedErrorMessage = expectedError ? c.getExpectedErrorMessage() : null;

            boolean isNullExpected = false;
            boolean isBooleanExpected = false;
            boolean booleanValue = false;
            boolean isFloatingPointExpected = false;
            String expectedValue = null;

            if (expectedError) {
                hasExceptions = true;
            } else if (c.expected() == null || c.expected().isNull()) {
                isNullExpected = true;
                expectedValue = "null";
            } else if (c.expected().isBoolean()) {
                isBooleanExpected = true;
                booleanValue = c.expected().asBoolean();
                expectedValue = Boolean.toString(booleanValue);
            } else if (c.expected().isFloatingPointNumber()) {
                isFloatingPointExpected = true;
                hasFloatingPoint = true;
                expectedValue = JavaTypeFormatter.format(c.expected());
            } else {
                expectedValue = JavaTypeFormatter.format(c.expected());
            }

            if (invocationCode.contains("List.of(") || (expectedValue != null && expectedValue.contains("List.of("))) {
                hasList = true;
            }
            if (invocationCode.contains("Map.of(") || (expectedValue != null && expectedValue.contains("Map.of("))
                || invocationCode.contains("Map.entry(") || (expectedValue != null && expectedValue.contains("Map.entry("))) {
                hasMap = true;
            }
            if (invocationCode.contains("Set.of(") || (expectedValue != null && expectedValue.contains("Set.of("))) {
                hasSet = true;
            }

            renderedCases.add(new RenderedTestCase(
                c.uuid(),
                c.description(),
                methodName,
                disabled,
                expectedError,
                expectedException,
                expectedErrorMessage,
                isNullExpected,
                isBooleanExpected,
                booleanValue,
                isFloatingPointExpected,
                expectedValue,
                invocationCode,
                property,
                formattedInputs,
                inputNodes,
                c.input(),
                c
            ));
        }

        RenderedExercise renderedExercise = new RenderedExercise(
            slug,
            testClassName,
            solutionClassName,
            hasExceptions,
            hasFloatingPoint,
            hasList,
            hasMap,
            hasSet,
            renderedCases.size() > 1,
            renderedCases
        );

        String generatedContent = templateRenderer.render(renderedExercise, exerciseDirectory);
        generatedContent = cleanWhitespace(generatedContent);

        return new GenerationResult(slug, targetTestPath, generatedContent, renderedCases.size(), allCases.size() - renderedCases.size());
    }

    private String cleanWhitespace(String code) {
        if (code == null) return "";
        // Normalize line endings to \n
        String normalized = code.replace("\r\n", "\n").replace('\r', '\n');
        // Collapse 3 or more consecutive newlines into 2 newlines
        normalized = normalized.replaceAll("\n{3,}", "\n\n");
        return normalized.trim() + "\n";
    }

    public record GenerationResult(
        String slug,
        Path targetTestPath,
        String content,
        int includedCasesCount,
        int excludedCasesCount
    ) {
        public void writeToFile() throws IOException {
            if (content == null || includedCasesCount == 0) {
                return;
            }
            Files.createDirectories(targetTestPath.getParent());
            Files.writeString(targetTestPath, content, StandardCharsets.UTF_8);
        }
    }
}
