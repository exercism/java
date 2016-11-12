import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class QueenAttackCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testNoExceptionThrownIfBothQueenPositionsValid() {
        new QueenAttackCalculator(new BoardCoordinate(2, 2), new BoardCoordinate(0, 7));
    }

    @Ignore
    @Test
    public void testNullInputNotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You must supply valid board coordinates for both Queens.");

        new QueenAttackCalculator(null, new BoardCoordinate(0, 7));
    }

    @Ignore
    @Test
    public void testNegativeRankNotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Coordinate must have positive rank.");

        new BoardCoordinate(-2, 2);
    }

    @Ignore
    @Test
    public void testRankGreaterThan7NotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Coordinate must have rank <= 7.");

        new BoardCoordinate(8, 4);
    }

    @Ignore
    @Test
    public void testNegativeFileNotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Coordinate must have positive file.");

        new BoardCoordinate(2, -2);
    }

    @Ignore
    @Test
    public void testFileGreaterThan7NotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Coordinate must have file <= 7.");

        new BoardCoordinate(4, 8);
    }

    @Ignore
    @Test
    public void testQueensMustNotOccupyTheSameSquare() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Queens may not occupy the same board coordinate.");

        new QueenAttackCalculator(new BoardCoordinate(2, 2), new BoardCoordinate(2, 2));
    }

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
