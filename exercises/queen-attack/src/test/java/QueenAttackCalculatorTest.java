import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;


public class QueenAttackCalculatorTest {

    @Test
    public void testCreateQueenWithAValidPosition() {
        new Queen(2, 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCreateQueenMustHavePositiveRow() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new Queen(-2, 2));

        assertThat(expected)
            .hasMessage("Queen position must have positive row.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testCreateQueenMustHaveRowOnBoard() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new Queen(8, 4));

        assertThat(expected)
            .hasMessage("Queen position must have row <= 7.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testCreateQueenMustHavePositiveColumn() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new Queen(2, -2));

        assertThat(expected)
            .hasMessage("Queen position must have positive column.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testCreateQueenMustHaveColumnOnBoard() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new Queen(4, 8));

        assertThat(expected)
            .hasMessage("Queen position must have column <= 7.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensCannotAttack() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 4), new Queen(6, 6));

        assertFalse(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensCanAttackOnTheSameRow() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 4), new Queen(2, 6));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensCanAttackOnTheSameColumn() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(4, 5), new Queen(2, 5));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensCanAttackOnFirstDiagonal() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 2), new Queen(0, 4));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensCanAttackOnSecondDiagonal() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 2), new Queen(3, 1));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensCanAttackOnThirdDiagonal() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 2), new Queen(1, 1));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensCanAttackOnFourthDiagonal() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(1, 7), new Queen(0, 6));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testNullPositionsNotAllowed() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new QueenAttackCalculator(null, new Queen(0, 7)));

        assertThat(expected)
            .hasMessage("You must supply valid positions for both Queens.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensMustNotOccupyTheSameSquare() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new QueenAttackCalculator(new Queen(2, 2), new Queen(2, 2)));

        assertThat(expected)
            .hasMessage("Queens cannot occupy the same position.");
    }

}
