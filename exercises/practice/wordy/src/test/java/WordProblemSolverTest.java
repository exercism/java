import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WordProblemSolverTest {

    WordProblemSolver solver = new WordProblemSolver();

    @Test
    @DisplayName("just a number")
    public void testJustANumber() {
        assertThat(solver.solve("What is 5?")).isEqualTo(5);
    }

    @Test
    @DisplayName("just a zero")
    public void testJustAZero() {
        assertThat(solver.solve("What is 0?")).isEqualTo(0);
    }

    @Test
    @DisplayName("just a negative number")
    public void testJustANegativeNumber() {
        assertThat(solver.solve("What is -123?")).isEqualTo(-123);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("addition")
    public void testSingleAddition1() {
        assertThat(solver.solve("What is 1 plus 1?")).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("addition with a left hand zero")
    public void testAdditionWithALeftHandZero() {
        assertThat(solver.solve("What is 0 plus 2?")).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("addition with a right hand zero")
    public void testAdditionWithARightHandZero() {
        assertThat(solver.solve("What is 3 plus 0?")).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("more addition")
    public void testSingleAddition2() {
        assertThat(solver.solve("What is 53 plus 2?")).isEqualTo(55);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("addition with negative numbers")
    public void testSingleAdditionWithNegativeNumbers() {
        assertThat(solver.solve("What is -1 plus -10?")).isEqualTo(-11);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("large addition")
    public void testSingleAdditionOfLargeNumbers() {
        assertThat(solver.solve("What is 123 plus 45678?")).isEqualTo(45801);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("subtraction")
    public void testSingleSubtraction() {
        assertThat(solver.solve("What is 4 minus -12?")).isEqualTo(16);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiplication")
    public void testSingleMultiplication() {
        assertThat(solver.solve("What is -3 multiplied by 25?")).isEqualTo(-75);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("division")
    public void testSingleDivision() {
        assertThat(solver.solve("What is 33 divided by -3?")).isEqualTo(-11);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple additions")
    public void testMultipleAdditions() {
        assertThat(solver.solve("What is 1 plus 1 plus 1?")).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("addition and subtraction")
    public void testAdditionThenSubtraction() {
        assertThat(solver.solve("What is 1 plus 5 minus -2?")).isEqualTo(8);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple subtraction")
    public void testMultipleSubtractions() {
        assertThat(solver.solve("What is 20 minus 4 minus 13?")).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("subtraction then addition")
    public void testSubtractionThenAddition() {
        assertThat(solver.solve("What is 17 minus 6 plus 3?")).isEqualTo(14);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple multiplication")
    public void testMultipleMultiplications() {
        assertThat(solver.solve("What is 2 multiplied by -2 multiplied by 3?")).isEqualTo(-12);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("addition and multiplication")
    public void testAdditionThenMultiplication() {
        assertThat(solver.solve("What is -3 plus 7 multiplied by -2?")).isEqualTo(-8);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple division")
    public void testMultipleDivisions() {
        assertThat(solver.solve("What is -12 divided by 2 divided by -3?")).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("unknown operation")
    public void testUnknownOperation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is 52 cubed?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Non math question")
    public void testNonMathQuestion() {
        // See https://en.wikipedia.org/wiki/President_of_the_United_States if you really need to know!
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("Who is the President of the United States?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reject problem missing an operand")
    public void testMissingAnOperand() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is 1 plus?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reject problem with no operands or operator")
    public void testNoOperandsOrOperators() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reject two operations in a row")
    public void testTwoOperationsInARow() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is 1 plus plus 2?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reject two numbers in a row")
    public void testTwoNumbersAfterOperation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is 1 plus 2 1?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reject postfix notation")
    public void testPostfixNotation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is 1 2 plus?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reject prefix notation")
    public void testPrefixNotation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> solver.solve("What is plus 1 2?"))
                .withMessage("I'm sorry, I don't understand the question!");
    }
}
