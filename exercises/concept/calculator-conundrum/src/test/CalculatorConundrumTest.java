import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

public class CalculatorConundrumTest {

    @Test
    public void additionWithSmallOperands() throws IllegalOperationException {
        assertThat(new CalculatorConundrum(22, 25, "+").calculate()).isEqualTo("22 + 25 = 47");
    }

    @Ignore("Remove to run test")
    @Test
    public void additionWithLargeOperands() throws IllegalOperationException {
        assertThat(new CalculatorConundrum(378_961, 399_635, "+").calculate()).isEqualTo("378961 + 399635 = 778596");
    }

    //    @Ignore("Remove to run test")
    @Test
    public void multiplicationWithSmallOperands() throws IllegalOperationException {
        assertThat(new CalculatorConundrum(3, 21, "*").calculate()).isEqualTo("3 * 21 = 63");
    }

    @Ignore("Remove to run test")
    @Test
    public void multiplicationWithLargeOperands() throws IllegalOperationException {
        assertThat(new CalculatorConundrum(72_441, 2_048, "*").calculate()).isEqualTo("72441 * 2048 = 148359168");
    }

    @Ignore("Remove to run test")
    @Test
    public void divisionWithSmallOperands() throws IllegalOperationException {
        assertThat(new CalculatorConundrum(72, 9, "/").calculate()).isEqualTo("72 / 9 = 8");
    }

    @Ignore("Remove to run test")
    @Test
    public void divisionWithLargeOperands() throws IllegalOperationException {
        assertThat(new CalculatorConundrum(1_338_800, 83_675, "/").calculate()).isEqualTo("1338800 / 83675 = 16");
    }

    @Ignore("Remove to run test")
    @Test
    public void throwExceptionForDivisionByZero() {
        ArithmeticException thrown = assertThrows(
                ArithmeticException.class,
                () -> new CalculatorConundrum(33, 0, "/")
        );
        assertThat(thrown).hasMessage("Divide by zero operation illegal");
    }

    @Ignore("Remove to run test")
    @Test
    public void throwExceptionForNonValidArguments() {
        String invalidOperation = "**";
        IllegalOperationException thrown = assertThrows(
                IllegalOperationException.class,
                () -> new CalculatorConundrum(3, 78, invalidOperation)
        );
        assertThat(thrown).hasMessage(String.format("%s operation does not exist", invalidOperation));
    }

    @Ignore("Remove to run test")
    @Test
    public void throwExceptionForNullAsOperation() {
        IllegalOperationException thrown = assertThrows(
                IllegalOperationException.class,
                () -> new CalculatorConundrum(66, 65, null)
        );
        assertThat(thrown).hasMessage("Operation cannot be null");
    }

    @Ignore("Remove to run test")
    @Test
    public void throwExceptionForAnEmptyStringOperation() {
        IllegalOperationException thrown = assertThrows(
                IllegalOperationException.class,
                () -> new CalculatorConundrum(34, 324, "")
        );
        assertThat(thrown).hasMessage("Operation cannot be empty");
    }
}
