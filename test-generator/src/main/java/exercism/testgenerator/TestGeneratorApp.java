package exercism.testgenerator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exercism.testgenerator.model.CanonicalDataNotFoundException;
import exercism.testgenerator.service.ExerciseTestGenerator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.stream.Stream;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
    name = "test-generator",
    mixinStandardHelpOptions = true,
    version = "1.1.0",
    description = "Generates and updates JUnit test files for Exercism Java practice exercises from upstream canonical data."
)
public class TestGeneratorApp implements Callable<Integer> {

    @Option(
        names = {"-e", "--exercise"},
        description = "One or more exercise slugs to generate tests for (e.g. -e acronym -e two-fer)"
    )
    private List<String> exercises = new ArrayList<>();

    @Option(
        names = {"-a", "--all"},
        description = "Generate tests for all practice exercises"
    )
    private boolean all;

    @Option(
        names = {"-d", "--dry-run"},
        description = "Print generated code to console without writing files"
    )
    private boolean dryRun;

    @Option(
        names = {"--audit"},
        description = "Run track audit across exercises without writing files, summarizing template usage and issues"
    )
    private boolean audit;

    @Option(
        names = {"--include-deprecated"},
        description = "Include deprecated exercises when running with --all"
    )
    private boolean includeDeprecated;

    @Option(
        names = {"-p", "--path"},
        description = "Path to the root of the exercism/java repository"
    )
    private Path repositoryRoot;

    private final ExerciseTestGenerator generator = new ExerciseTestGenerator();
    private final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        int exitCode = new CommandLine(new TestGeneratorApp()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        Path repoRoot = resolveRepositoryRoot();
        if (repoRoot == null) {
            System.err.println("Error: Could not locate exercism/java repository root with 'exercises/practice' folder.");
            return 1;
        }

        Path practiceDir = repoRoot.resolve("exercises").resolve("practice");
        if (!Files.isDirectory(practiceDir)) {
            System.err.println("Error: Directory not found: " + practiceDir);
            return 1;
        }

        Set<String> deprecatedSlugs = loadDeprecatedExercises(repoRoot);
        List<String> targets = new ArrayList<>(exercises);

        if (all) {
            try (Stream<Path> stream = Files.list(practiceDir)) {
                List<String> allSlugs = stream
                    .filter(Files::isDirectory)
                    .filter(p -> Files.exists(p.resolve(".meta").resolve("config.json")))
                    .map(p -> p.getFileName().toString())
                    .filter(slug -> includeDeprecated || !deprecatedSlugs.contains(slug))
                    .sorted()
                    .toList();
                targets.addAll(allSlugs);
            } catch (IOException e) {
                System.err.println("Failed to list exercises: " + e.getMessage());
                return 1;
            }
        }

        if (targets.isEmpty()) {
            System.err.println("Error: Please specify at least one exercise using -e/--exercise <slug> or use --all.");
            new CommandLine(this).usage(System.out);
            return 1;
        }

        System.out.printf("🚀 Running Exercism Java Test Generator for %d exercise(s)...%n%n", targets.size());

        int defaultTemplateCount = 0;
        int customTemplateCount = 0;
        int noCanonicalDataCount = 0;
        int failureCount = 0;

        for (String slug : targets) {
            Path exerciseDir = practiceDir.resolve(slug);
            if (!Files.isDirectory(exerciseDir)) {
                System.err.printf("❌ Exercise '%s' not found at %s%n", slug, exerciseDir);
                failureCount++;
                continue;
            }

            boolean hasCustomTemplate = Files.exists(exerciseDir.resolve(".meta").resolve("template.hbs"));

            try {
                if (!audit) {
                    System.out.printf("🔄 Processing '%s'...", slug);
                }
                ExerciseTestGenerator.GenerationResult result = generator.generate(exerciseDir);

                if (result.includedCasesCount() == 0) {
                    noCanonicalDataCount++;
                    if (audit) {
                        System.out.printf("  [SKIP] %-28s (all test cases excluded in tests.toml)%n", slug);
                    } else {
                        System.out.printf(" ⚠️ Skipped '%s': all test cases excluded in tests.toml%n", slug);
                    }
                    continue;
                }

                if (hasCustomTemplate) {
                    customTemplateCount++;
                } else {
                    defaultTemplateCount++;
                }

                if (audit) {
                    String templateType = hasCustomTemplate ? "custom template" : "default template";
                    System.out.printf("  [OK] %-30s (%2d cases, %s)%n", slug, result.includedCasesCount(), templateType);
                } else if (dryRun) {
                    System.out.printf(" [DRY RUN - %d tests included, %d excluded]%n",
                        result.includedCasesCount(), result.excludedCasesCount());
                    System.out.println("----------------------------------------");
                    System.out.println(result.content());
                    System.out.println("----------------------------------------");
                } else {
                    result.writeToFile();
                    System.out.printf(" ✅ Generated %s (%d test cases included, %d excluded)%n",
                        repoRoot.relativize(result.targetTestPath()),
                        result.includedCasesCount(),
                        result.excludedCasesCount());
                }
            } catch (CanonicalDataNotFoundException e) {
                noCanonicalDataCount++;
                if (audit) {
                    System.out.printf("  [SKIP] %-28s (track-specific, no upstream canonical data)%n", slug);
                } else {
                    System.out.printf(" ⚠️ Skipped: %s%n", e.getMessage());
                }
            } catch (Exception e) {
                failureCount++;
                if (audit) {
                    System.out.printf("  [FAIL] %-28s : %s%n", slug, e.getMessage());
                } else {
                    System.out.printf(" ❌ Failed: %s%n", e.getMessage());
                }
            }
        }

        int totalEvaluated = defaultTemplateCount + customTemplateCount + noCanonicalDataCount + failureCount;
        System.out.println();
        System.out.println("============================================================");
        System.out.println("Test Generator Summary");
        System.out.println("============================================================");
        System.out.printf("Total evaluated:                 %d%n", totalEvaluated);
        System.out.printf("  - With default template:       %d%n", defaultTemplateCount);
        System.out.printf("  - With custom template:        %d%n", customTemplateCount);
        System.out.printf("  - Track-specific (skipped):    %d%n", noCanonicalDataCount);
        System.out.printf("  - Failures:                    %d%n", failureCount);
        if (!includeDeprecated && !deprecatedSlugs.isEmpty()) {
            System.out.printf("  - Deprecated (skipped):        %d%n", deprecatedSlugs.size());
        }
        System.out.println("============================================================");

        return failureCount == 0 ? 0 : 1;
    }

    private Set<String> loadDeprecatedExercises(Path repoRoot) {
        Set<String> deprecated = new HashSet<>();
        Path configPath = repoRoot.resolve("config.json");
        if (!Files.exists(configPath)) {
            return deprecated;
        }

        try {
            JsonNode root = mapper.readTree(configPath.toFile());
            JsonNode practice = root.path("exercises").path("practice");
            if (practice.isArray()) {
                for (JsonNode node : practice) {
                    if ("deprecated".equalsIgnoreCase(node.path("status").asText())) {
                        deprecated.add(node.path("slug").asText());
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return deprecated;
    }

    private Path resolveRepositoryRoot() {
        if (repositoryRoot != null) {
            return repositoryRoot.toAbsolutePath().normalize();
        }

        Path current = Paths.get("").toAbsolutePath().normalize();
        if (Files.isDirectory(current.resolve("exercises").resolve("practice"))) {
            return current;
        }

        Path parent = current.getParent();
        if (parent != null && Files.isDirectory(parent.resolve("exercises").resolve("practice"))) {
            return parent;
        }

        return null;
    }
}
