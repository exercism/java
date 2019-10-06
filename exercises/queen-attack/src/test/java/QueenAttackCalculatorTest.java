import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueenAttackCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCreateQueenWithAValidPosition() {
        new Queen(2, 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCreateQueenMustHavePositiveRow() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Queen position must have positive row.");

        new Queen(-2, 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCreateQueenMustHaveRowOnBoard() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Queen position must have row <= 7.");

        new Queen(8, 4);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCreateQueenMustHavePositiveColumn() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Queen position must have positive column.");

        new Queen(2, -2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCreateQueenMustHaveColumnOnBoard() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Queen position must have column <= 7.");

        new Queen(4, 8);
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
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You must supply valid positions for both Queens.");

        new QueenAttackCalculator(null, new Queen(0, 7));
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensMustNotOccupyTheSameSquare() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Queens cannot occupy the same position.");

        new QueenAttackCalculator(new Queen(2, 2), new Queen(2, 2));
    }

}
