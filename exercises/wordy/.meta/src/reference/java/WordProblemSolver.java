import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class WordProblemSolver {

    private static final String INTEGER_REGEX_STRING = "(-?\\d+)";

    private static final String BINARY_OPERATION_REGEX_STRING = "(plus|minus|multiplied by|divided by)";

    private static final String VALID_QUESTION_REGEX_STRING =
            "^What is " + INTEGER_REGEX_STRING +
            "( " + BINARY_OPERATION_REGEX_STRING + " " + INTEGER_REGEX_STRING + ")*" +
            "\\?$";

    int solve(final String wordProblem) {
        if (!wordProblem.matches(VALID_QUESTION_REGEX_STRING)) {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }

        final Matcher initialValueMatcher = Pattern.compile(INTEGER_REGEX_STRING).matcher(wordProblem);

        initialValueMatcher.find();
        int result = Integer.parseInt(initialValueMatcher.group());

        final Matcher operationAndValueMatcher
                = Pattern.compile(BINARY_OPERATION_REGEX_STRING + " " + INTEGER_REGEX_STRING).matcher(wordProblem);

        while (operationAndValueMatcher.find()) {
            result = applyBinaryOperation(
                result,
                operationAndValueMatcher.group(1),
                Integer.parseInt(operationAndValueMatcher.group(2)));
        }

        return result;
    }

    private int applyBinaryOperation(
            final int firstValue,
            final String operationDescription,
            final int secondValue) {

        switch (operationDescription) {
            case "plus":
                return firstValue + secondValue;
            case "minus":
                return firstValue - secondValue;
            case "multiplied by":
                return firstValue * secondValue;
            case "divided by":
                return firstValue / secondValue;
            default:
                throw new IllegalArgumentException("This branch should never be executed.");
        }
    }

}
