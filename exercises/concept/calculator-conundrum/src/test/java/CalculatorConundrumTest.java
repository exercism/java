import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

public class CalculatorConundrumTest {

    @Test
    public void additionWithSmallOperands() {
        assertThat(new CalculatorConundrum().calculate(22, 25, "+")).isEqualTo("22 + 25 = 47");
    }

    @Ignore("Remove to run test")
    @Test
    public void additionWithLargeOperands() {
        assertThat(new CalculatorConundrum().calculate(378_961, 399_635, "+")).isEqualTo("378961 + 399635 = 778596");
    }

    @Ignore("Remove to run test")
    @Test
    public void multiplicationWithSmallOperands() {
        assertThat(new CalculatorConundrum().calculate(3, 21, "*")).isEqualTo("3 * 21 = 63");
    }

    @Ignore("Remove to run test")
    @Test
    public void multiplicationWithLargeOperands() {
        assertThat(new CalculatorConundrum().calculate(72_441, 2_048, "*")).isEqualTo("72441 * 2048 = 148359168");
    }

    @Ignore("Remove to run test")
    @Test
    public void divisionWithSmallOperands() {
        assertThat(new CalculatorConundrum().calculate(72, 9, "/")).isEqualTo("72 / 9 = 8");
    }

    @Ignore("Remove to run test")
    @Test
    public void divisionWithLargeOperands() {
        assertThat(new CalculatorConundrum().calculate(1_338_800, 83_675, "/")).isEqualTo("1338800 / 83675 = 16");
    }

    @Ignore("Remove to run test")
    @Test
    public void throwExceptionForDivisionByZero() {
        IllegalOperationException thrown = assertThrows(
                IllegalOperationException.class,
                () -> new CalculatorConundrum().calculate(33, 0, "/")
        );
        assertThat(thrown.getCause()).isInstanceOf(ArithmeticException.class);
        assertThat(thrown).hasMessage("Divide by zero operation illegal");
    }

    @Ignore("Remove to run test")
    @Test
    public void throwExceptionForNonValidArguments() {
        String invalidOperation = "**";
        IllegalOperationException thrown = assertThrows(
                IllegalOperationException.class,
                () -> new CalculatorConundrum().calculate(3, 78, invalidOperation)
        );
        assertThat(thrown).hasMessage(String.format("%s operation does not exist", invalidOperation));
    }

    @Ignore("Remove to run test")
    @Test
    public void throwExceptionForNullAsOperation() {
        IllegalOperationException thrown = assertThrows(
                IllegalOperationException.class,
                () -> new CalculatorConundrum().calculate(66, 65, null)
        );
        assertThat(thrown).hasMessage("Operation cannot be null");
    }

    @Ignore("Remove to run test")
    @Test
    public void throwExceptionForAnEmptyStringOperation() {
        IllegalOperationException thrown = assertThrows(
                IllegalOperationException.class,
                () -> new CalculatorConundrum().calculate(34, 324, "")
        );
        assertThat(thrown).hasMessage("Operation cannot be empty");
    }
}
