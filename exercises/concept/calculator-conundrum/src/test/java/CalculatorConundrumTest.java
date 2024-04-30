import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorConundrumTest {

    @Test
    @Tag("task:1")
    @DisplayName("The calculate method returns the correct result when adding small operands")
    public void additionWithSmallOperands() {
        assertThat(new CalculatorConundrum().calculate(22, 25, "+")).isEqualTo("22 + 25 = 47");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The calculate method returns the correct result when adding large operands")
    public void additionWithLargeOperands() {
        assertThat(new CalculatorConundrum().calculate(378_961, 399_635, "+")).isEqualTo("378961 + 399635 = 778596");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The calculate method returns the correct result when multiplying small operands")
    public void multiplicationWithSmallOperands() {
        assertThat(new CalculatorConundrum().calculate(3, 21, "*")).isEqualTo("3 * 21 = 63");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The calculate method returns the correct result when multiplying large operands")
    public void multiplicationWithLargeOperands() {
        assertThat(new CalculatorConundrum().calculate(72_441, 2_048, "*")).isEqualTo("72441 * 2048 = 148359168");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The calculate method returns the correct result when dividing small operands")
    public void divisionWithSmallOperands() {
        assertThat(new CalculatorConundrum().calculate(72, 9, "/")).isEqualTo("72 / 9 = 8");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The calculate method returns the correct result when dividing large operands")
    public void divisionWithLargeOperands() {
        assertThat(new CalculatorConundrum().calculate(1_338_800, 83_675, "/")).isEqualTo("1338800 / 83675 = 16");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The calculate method throws IllegalOperationException when passing invalid operation")
    public void throwExceptionForUnknownOperation() {
        String invalidOperation = "**";
        String expectedMessage = "Operation '" + invalidOperation + "' does not exist";
        assertThatExceptionOfType(IllegalOperationException.class)
                .isThrownBy(() -> new CalculatorConundrum().calculate(3, 78, invalidOperation))
                .withMessage(expectedMessage);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The calculate method throws IllegalArgumentException when passing null operation")
    public void throwExceptionForNullAsOperation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CalculatorConundrum().calculate(66, 65, null))
                .withMessage("Operation cannot be null");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The calculate method throws IllegalArgumentException when passing empty operation")
    public void throwExceptionForAnEmptyStringOperation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CalculatorConundrum().calculate(34, 324, ""))
                .withMessage("Operation cannot be empty");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The calculate method throws IllegalOperationException when dividing by zero")
    public void throwExceptionForDivisionByZero() {
        assertThatExceptionOfType(IllegalOperationException.class)
                .isThrownBy(() -> new CalculatorConundrum().calculate(33, 0, "/"))
                .withMessage("Division by zero is not allowed")
                .withCauseInstanceOf(ArithmeticException.class);
    }
}
