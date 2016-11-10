import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public final class QueenAttackCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testNoExceptionThrownIfBothQueenPositionsValid() {
        new QueenAttackCalculator(new int[]{2, 2}, new int[]{0, 7});
    }

    @Ignore
    @Test
    public void testNullInputNotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You must supply valid 2-dimensional coordinate arrays for both Queens.");

        new QueenAttackCalculator(null, new int[]{3, 4});
    }

    @Ignore
    @Test
    public void testNegativeRankNotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Queens must both have positive rank.");

        new QueenAttackCalculator(new int[]{-2, 2}, new int[]{2, 2});
    }

    @Ignore
    @Test
    public void testRankGreaterThan7NotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Queens must both have rank <= 7.");

        new QueenAttackCalculator(new int[]{8, 4}, new int[]{1, 6});
    }

    @Ignore
    @Test
    public void testNegativeFileNotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Queens must both have positive file.");

        new QueenAttackCalculator(new int[]{2, -2}, new int[]{5, 3});
    }

    @Ignore
    @Test
    public void testFileGreaterThan7NotAllowed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Queens must both have file <= 7.");

        new QueenAttackCalculator(new int[]{4, 8}, new int[]{7, 4});
    }

    @Ignore
    @Test
    public void testQueensMustNotOccupyTheSameSquare() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Queens must not occupy the same square.");

        new QueenAttackCalculator(new int[]{2, 2}, new int[]{2, 2});
    }

    @Ignore
    @Test
    public void testQueensCanAttackOnTheSameRank() {
        final QueenAttackCalculator calculator = new QueenAttackCalculator(new int[]{2, 4}, new int[]{2, 6});
        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore
    @Test
    public void testQueensCanAttackOnTheSameFile() {
        final QueenAttackCalculator calculator = new QueenAttackCalculator(new int[]{4, 5}, new int[]{2, 5});
        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore
    @Test
    public void testQueensCanAttackOnFirstDiagonal() {
        final QueenAttackCalculator calculator = new QueenAttackCalculator(new int[]{2, 2}, new int[]{0, 4});
        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore
    @Test
    public void testQueensCanAttackOnSecondDiagonal() {
        final QueenAttackCalculator calculator = new QueenAttackCalculator(new int[]{2, 2}, new int[]{3, 1});
        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore
    @Test
    public void testQueensCanAttackOnThirdDiagonal() {
        final QueenAttackCalculator calculator = new QueenAttackCalculator(new int[]{2, 2}, new int[]{1, 1});
        assertTrue(calculator.canQueensAttackOneAnother());
    }

    @Ignore
    @Test
    public void testQueensCanAttackOnFourthDiagonal() {
        final QueenAttackCalculator calculator = new QueenAttackCalculator(new int[]{2, 2}, new int[]{5, 5});
        assertTrue(calculator.canQueensAttackOneAnother());
    }

}
