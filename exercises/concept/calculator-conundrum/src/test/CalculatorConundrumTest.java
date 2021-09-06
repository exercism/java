import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class CalculatorConundrumTest {

    @Test
    public void additionWithSmallOperands() {
        assertEquals("22 + 25 = 47", new CalculatorConundrum(22, 25, "+").calculate());
    }

    @Ignore("Remove to run test")
    @Test
    public void additionWithLargeOperands() {
        assertEquals("378961 + 399635 = 778596", new CalculatorConundrum(378_961, 399_635, "+").calculate());
    }

    @Ignore("Remove to run test")
    @Test
    public void multiplicationWithSmallOperands() {
        assertEquals("3 * 21 = 63", new CalculatorConundrum(3, 21, "*").calculate());
    }

    @Ignore("Remove to run test")
    @Test
    public void multiplicationWithLargeOperands() {
        assertEquals("72441 * 2048 = 148359168", new CalculatorConundrum(72_441, 2_048, "*").calculate());
    }

    @Ignore("Remove to run test")
    @Test
    public void divisionWithSmallOperands() {
        assertEquals("72 / 9 = 8", new CalculatorConundrum(72, 9, "/").calculate());
    }

    @Ignore("Remove to run test")
    @Test
    public void divisionWithLargeOperands() {
        assertEquals("1338800 / 83675 = 16", new CalculatorConundrum(1_338_800, 83_675, "/").calculate());
    }

    @Ignore("Remove to run test")
    @Test
    public void throwExceptionForDivisionByZero() {
        ArithmeticException thrown = assertThrows(
                ArithmeticException.class,
                () -> new CalculatorConundrum(33, 0, "/")
        );
        assertTrue(thrown.getMessage().contains("/ by zero"));
    }

    @Ignore("Remove to run test")
    @Test
    public void throwExceptionForNonValidArguments() {
        String invalidOperation = "**";
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new CalculatorConundrum(3, 78, invalidOperation)
        );
        assertTrue(thrown.getMessage().contains(String.format("%s operation does not exist", invalidOperation)));
    }

    @Ignore("Remove to run test")
    @Test
    public void throwExceptionForNullAsOperation() {
        assertThrows(
                NullPointerException.class,
                () -> new CalculatorConundrum(66, 65, null)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void throwExceptionForAnEmptyStringOperation() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new CalculatorConundrum(34, 324, "")
        );
        assertTrue(thrown.getMessage().contains("Operation cannot be empty"));
    }
}
