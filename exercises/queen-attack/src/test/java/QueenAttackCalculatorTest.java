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
    public void testQueensThatDoNotShareRowColumnOrDiagonalCannotAttack() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(2, 4), new BoardCoordinate(6, 6));

        assertFalse(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensCanAttackOnTheSameRow() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(2, 4), new BoardCoordinate(2, 6));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensCanAttackOnTheSameColumn() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(4, 5), new BoardCoordinate(2, 5));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensCanAttackOnFirstDiagonal() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(2, 2), new BoardCoordinate(0, 4));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensCanAttackOnSecondDiagonal() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(2, 2), new BoardCoordinate(3, 1));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensCanAttackOnThirdDiagonal() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(2, 2), new BoardCoordinate(1, 1));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensCanAttackOnFourthDiagonal() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(2, 2), new BoardCoordinate(5, 5));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCoordinateWithNegativeRowNotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Coordinate must have positive row.");

        new BoardCoordinate(-2, 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCoordinateWithRowGreaterThan7NotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Coordinate must have row <= 7.");

        new BoardCoordinate(8, 4);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCoordinateWithNegativeColumnNotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Coordinate must have positive column.");

        new BoardCoordinate(2, -2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCoordinateWithColumnGreaterThan7NotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Coordinate must have column <= 7.");

        new BoardCoordinate(4, 8);
    }

    @Ignore("Remove to run test")
    @Test
    public void testNullCoordinateNotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You must supply valid board coordinates for both Queens.");

        new QueenAttackCalculator(null, new BoardCoordinate(0, 7));
    }

    @Ignore("Remove to run test")
    @Test
    public void testQueensMustNotOccupyTheSameSquare() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Queens may not occupy the same board coordinate.");

        new QueenAttackCalculator(new BoardCoordinate(2, 2), new BoardCoordinate(2, 2));
    }

}
