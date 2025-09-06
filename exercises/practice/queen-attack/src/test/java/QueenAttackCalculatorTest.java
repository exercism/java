import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


public class QueenAttackCalculatorTest {

    @Test
    @DisplayName("queen with a valid position")
    public void testCreateQueenWithAValidPosition() {
        new Queen(2, 2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("queen must have positive row")
    public void testCreateQueenMustHavePositiveRow() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Queen(-2, 2))
                .withMessage("Queen position must have positive row.");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("queen must have row on board")
    public void testCreateQueenMustHaveRowOnBoard() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Queen(8, 4))
                .withMessage("Queen position must have row <= 7.");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("queen must have positive column")
    public void testCreateQueenMustHavePositiveColumn() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Queen(2, -2))
                .withMessage("Queen position must have positive column.");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("queen must have column on board")
    public void testCreateQueenMustHaveColumnOnBoard() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Queen(4, 8))
                .withMessage("Queen position must have column <= 7.");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("cannot attack")
    public void testQueensCannotAttack() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 4), new Queen(6, 6));

        assertThat(calculator.canQueensAttackOneAnother()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can attack on same row")
    public void testQueensCanAttackOnTheSameRow() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 4), new Queen(2, 6));

        assertThat(calculator.canQueensAttackOneAnother()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can attack on same column")
    public void testQueensCanAttackOnTheSameColumn() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(4, 5), new Queen(2, 5));

        assertThat(calculator.canQueensAttackOneAnother()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can attack on first diagonal")
    public void testQueensCanAttackOnFirstDiagonal() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 2), new Queen(0, 4));

        assertThat(calculator.canQueensAttackOneAnother()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can attack on second diagonal")
    public void testQueensCanAttackOnSecondDiagonal() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 2), new Queen(3, 1));

        assertThat(calculator.canQueensAttackOneAnother()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can attack on third diagonal")
    public void testQueensCanAttackOnThirdDiagonal() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(2, 2), new Queen(1, 1));

        assertThat(calculator.canQueensAttackOneAnother()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can attack on fourth diagonal")
    public void testQueensCanAttackOnFourthDiagonal() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(1, 7), new Queen(0, 6));

        assertThat(calculator.canQueensAttackOneAnother()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("cannot attack if falling diagonals are only the same " +
            "when reflected across the longest falling diagonal")
    public void testQueenCannotAttackIfFallingDiagonalsAreOnlyTheSameWhenReflectedAcrossTheLongestFallingDiagonal() {
        QueenAttackCalculator calculator
                = new QueenAttackCalculator(new Queen(4, 1), new Queen(2, 5));

        assertThat(calculator.canQueensAttackOneAnother()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void testNullPositionsNotAllowed() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new QueenAttackCalculator(null, new Queen(0, 7)))
                .withMessage("You must supply valid positions for both Queens.");
    }

    @Disabled("Remove to run test")
    @Test
    public void testQueensMustNotOccupyTheSameSquare() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new QueenAttackCalculator(new Queen(2, 2), new Queen(2, 2)))
                .withMessage("Queens cannot occupy the same position.");
    }

}
