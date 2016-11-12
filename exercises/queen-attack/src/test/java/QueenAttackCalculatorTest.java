import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class QueenAttackCalculatorTest {

    /*
     * See https://github.com/junit-team/junit4/wiki/Rules for information on JUnit Rules in general and
     * ExpectedExceptions in particular.
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Ignore
    @Test
    public void testCoordinateWithNegativeRankNotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Coordinate must have positive rank.");

        new BoardCoordinate(-2, 2);
    }

    @Ignore
    @Test
    public void testCoordinateWithRankGreaterThan7NotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Coordinate must have rank <= 7.");

        new BoardCoordinate(8, 4);
    }

    @Ignore
    @Test
    public void testCoordinateWithNegativeFileNotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Coordinate must have positive file.");

        new BoardCoordinate(2, -2);
    }

    @Ignore
    @Test
    public void testCoordinateWithFileGreaterThan7NotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Coordinate must have file <= 7.");

        new BoardCoordinate(4, 8);
    }

    @Ignore
    @Test
    public void testNullCoordinateNotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You must supply valid board coordinates for both Queens.");

        new QueenAttackCalculator(null, new BoardCoordinate(0, 7));
    }

    @Ignore
    @Test
    public void testQueensMustNotOccupyTheSameSquare() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Queens may not occupy the same board coordinate.");

        new QueenAttackCalculator(new BoardCoordinate(2, 2), new BoardCoordinate(2, 2));
    }

    @Ignore
    @Test
    public void testQueensThatDoNotShareRankFileOrDiagonalCannotAttack() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(2, 4), new BoardCoordinate(6, 6));

        assertFalse(calculator.canQueensAttackOneAnother());
    }

    @Ignore
    @Test
    public void testQueensCanAttackOnTheSameRank() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(2, 4), new BoardCoordinate(2, 6));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore
    @Test
    public void testQueensCanAttackOnTheSameFile() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(4, 5), new BoardCoordinate(2, 5));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore
    @Test
    public void testQueensCanAttackOnFirstDiagonal() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(2, 2), new BoardCoordinate(0, 4));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore
    @Test
    public void testQueensCanAttackOnSecondDiagonal() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(2, 2), new BoardCoordinate(3, 1));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore
    @Test
    public void testQueensCanAttackOnThirdDiagonal() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(2, 2), new BoardCoordinate(1, 1));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore
    @Test
    public void testQueensCanAttackOnFourthDiagonal() {
        final QueenAttackCalculator calculator
                = new QueenAttackCalculator(new BoardCoordinate(2, 2), new BoardCoordinate(5, 5));

        assertTrue(calculator.canQueensAttackOneAnother());
    }

}
