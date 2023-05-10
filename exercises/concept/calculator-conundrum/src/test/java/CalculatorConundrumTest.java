import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class CalculatorConundrumTest {

    @Test
    public void additionWithSmallOperands() {
        assertThat(new CalculatorConundrum().calculate(22, 25, "+")).isEqualTo("22 + 25 = 47");
    }

    @Test
    public void additionWithLargeOperands() {
        assertThat(new CalculatorConundrum().calculate(378_961, 399_635, "+")).isEqualTo("378961 + 399635 = 778596");
    }

    @Test
    public void multiplicationWithSmallOperands() {
        assertThat(new CalculatorConundrum().calculate(3, 21, "*")).isEqualTo("3 * 21 = 63");
    }

    @Test
    public void multiplicationWithLargeOperands() {
        assertThat(new CalculatorConundrum().calculate(72_441, 2_048, "*")).isEqualTo("72441 * 2048 = 148359168");
    }

    @Test
    public void divisionWithSmallOperands() {
        assertThat(new CalculatorConundrum().calculate(72, 9, "/")).isEqualTo("72 / 9 = 8");
    }

    @Test
    public void divisionWithLargeOperands() {
        assertThat(new CalculatorConundrum().calculate(1_338_800, 83_675, "/")).isEqualTo("1338800 / 83675 = 16");
    }

    @Test
    public void throwExceptionForDivisionByZero() {
        IllegalOperationException thrown = assertThrows(
                IllegalOperationException.class,
                () -> new CalculatorConundrum().calculate(33, 0, "/")
        );
        assertThat(thrown.getCause()).isInstanceOf(ArithmeticException.class);
        assertThat(thrown).hasMessage("Divide by zero operation illegal");
    }

    @Test
    public void throwExceptionForNonValidArguments() {
        String invalidOperation = "**";
        IllegalOperationException thrown = assertThrows(
                IllegalOperationException.class,
                () -> new CalculatorConundrum().calculate(3, 78, invalidOperation)
        );
        assertThat(thrown).hasMessage(String.format("%s operation does not exist", invalidOperation));
    }

    @Test
    public void throwExceptionForNullAsOperation() {
        IllegalOperationException thrown = assertThrows(
                IllegalOperationException.class,
                () -> new CalculatorConundrum().calculate(66, 65, null)
        );
        assertThat(thrown).hasMessage("Operation cannot be null");
    }

    @Test
    public void throwExceptionForAnEmptyStringOperation() {
        IllegalOperationException thrown = assertThrows(
                IllegalOperationException.class,
                () -> new CalculatorConundrum().calculate(34, 324, "")
        );
        assertThat(thrown).hasMessage("Operation cannot be empty");
    }
}
