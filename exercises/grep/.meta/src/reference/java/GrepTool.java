import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class GrepTool {

    String grep(String pattern, List<String> flags, List<String> files) {
        boolean shouldAddFilenameToEachLine = files.size() > 1;
        return files
            .stream()
            .map(file -> grepFile(pattern, flags, file, shouldAddFilenameToEachLine))
            .filter(line -> !line.isEmpty())
            .collect(Collectors.joining("\n"));
    }

    private String grepFile(String pattern, List<String> flags, String filename, boolean shouldAddFilenameToEachLine) {
        List<String> lines = readFile(filename);

        String matchingLines = IntStream.range(0, lines.size())
            .filter(lineIndex -> lineMatchesPattern(lines.get(lineIndex), pattern, flags))
            .mapToObj(lineIndex -> {
                String lineWithFlagsApplied = applyFlagsToLine(lines.get(lineIndex), flags, lineIndex + 1);
                return shouldAddFilenameToEachLine ? filename + ":" + lineWithFlagsApplied : lineWithFlagsApplied;
            })
            .collect(Collectors.joining("\n"));

        boolean shouldPrintFilenameInsteadOfMatchingLines = flags.contains("-l");
        return shouldPrintFilenameInsteadOfMatchingLines && !matchingLines.isEmpty() ? filename : matchingLines;
    }

    private boolean lineMatchesPattern(String line, String pattern, List<String> flags) {
        boolean isCaseInsensitive = flags.contains("-i");
        String lineToCompare = isCaseInsensitive ? line.toLowerCase() : line;
        String patternToCompare = isCaseInsensitive ? pattern.toLowerCase() : pattern;

        boolean shouldMatchEntireLine = flags.contains("-x");
        boolean matchesPattern = shouldMatchEntireLine
            ? lineToCompare.equals(patternToCompare)
            : lineToCompare.contains(patternToCompare);

        boolean shouldInvertMatch = flags.contains("-v");
        //noinspection SimplifiableConditionalExpression
        return shouldInvertMatch ? !matchesPattern : matchesPattern;
    }


    private String applyFlagsToLine(String line, List<String> flags, int lineNumber) {
        boolean shouldAddLineNumber = flags.contains("-n");
        return shouldAddLineNumber ? lineNumber + ":" + line : line;
    }

    private List<String> readFile(String filename) {
        try {
            return Files.readAllLines(Paths.get(filename), Charset.forName("UTF-8"));
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

}
