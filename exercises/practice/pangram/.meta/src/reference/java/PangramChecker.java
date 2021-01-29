import java.util.Arrays;
import java.util.stream.Collectors;

public class PangramChecker {
    private static final int alphaLength = 26;

    public boolean isPangram(String input) {
        return Arrays.stream(input.replaceAll("[^a-zA-Z]", "")
                .toLowerCase()
                .split(""))
                .collect(Collectors.toSet())
                .size() == alphaLength;
    }
}
