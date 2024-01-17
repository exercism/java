import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AlphameticsTest {

    @Test
    public void testThreeLetters() throws UnsolvablePuzzleException {
        assertThat(new Alphametics("I + BB == ILL").solve())
                .containsOnly(
                        entry('I', 1),
                        entry('B', 9),
                        entry('L', 0));
    }

    @Disabled("Remove to run test")
    @Test
    public void testUniqueValue() {
        Alphametics alphametics = new Alphametics("A == B");

        assertThatExceptionOfType(UnsolvablePuzzleException.class)
            .isThrownBy(alphametics::solve);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLeadingZero() {
        Alphametics alphametics = new Alphametics("ACA + DD == BD");

        assertThatExceptionOfType(UnsolvablePuzzleException.class)
            .isThrownBy(alphametics::solve);
    }

    @Disabled("Remove to run test")
    @Test
    public void testTwoDigitsFinalCarry() throws UnsolvablePuzzleException {
        assertThat(new Alphametics("A + A + A + A + A + A + A + A + A + A + A + B == BCC").solve())
                .containsOnly(
                        entry('A', 9),
                        entry('B', 1),
                        entry('C', 0));
    }

    @Disabled("Remove to run test")
    @Test
    public void testFourLetters() throws UnsolvablePuzzleException {
        assertThat(new Alphametics("AS + A == MOM").solve())
                .containsOnly(
                        entry('A', 9),
                        entry('S', 2),
                        entry('M', 1),
                        entry('O', 0));
    }

    @Disabled("Remove to run test")
    @Test
    public void testSixLetters() throws UnsolvablePuzzleException {
        assertThat(new Alphametics("NO + NO + TOO == LATE").solve())
                .containsOnly(
                        entry('N', 7),
                        entry('O', 4),
                        entry('T', 9),
                        entry('L', 1),
                        entry('A', 0),
                        entry('E', 2));
    }

    @Disabled("Remove to run test")
    @Test
    public void testSevenLetters() throws UnsolvablePuzzleException {
        assertThat(new Alphametics("HE + SEES + THE == LIGHT").solve())
                .containsOnly(
                        entry('E', 4),
                        entry('G', 2),
                        entry('H', 5),
                        entry('I', 0),
                        entry('L', 1),
                        entry('S', 9),
                        entry('T', 7));
    }

    @Disabled("Remove to run test")
    @Test
    public void testEightLetters() throws UnsolvablePuzzleException {
        assertThat(new Alphametics("SEND + MORE == MONEY").solve())
                .containsOnly(
                        entry('S', 9),
                        entry('E', 5),
                        entry('N', 6),
                        entry('D', 7),
                        entry('M', 1),
                        entry('O', 0),
                        entry('R', 8),
                        entry('Y', 2));
    }

    @Disabled("Remove to run test")
    @Test
    public void testTenLetters() throws UnsolvablePuzzleException {
        assertThat(new Alphametics("AND + A + STRONG + OFFENSE + AS + A + GOOD == DEFENSE").solve())
                .containsOnly(
                        entry('A', 5),
                        entry('D', 3),
                        entry('E', 4),
                        entry('F', 7),
                        entry('G', 8),
                        entry('N', 0),
                        entry('O', 2),
                        entry('R', 1),
                        entry('S', 6),
                        entry('T', 9));
    }

    @Disabled("Remove to run test")
    @Test
    public void testTenLetters41Addends() throws UnsolvablePuzzleException {
        assertThat(new Alphametics("THIS + A + FIRE + THEREFORE + FOR + ALL + HISTORIES + I + TELL + A + " +
                "TALE + THAT + FALSIFIES + ITS + TITLE + TIS + A + LIE + THE + TALE + OF + THE + LAST + FIRE + " +
                "HORSES + LATE + AFTER + THE + FIRST + FATHERS + FORESEE + THE + HORRORS + THE + LAST + FREE + " +
                "TROLL + TERRIFIES + THE + HORSES + OF + FIRE + THE + TROLL + RESTS + AT + THE + HOLE + OF + " +
                "LOSSES + IT + IS + THERE + THAT + SHE + STORES + ROLES + OF + LEATHERS + AFTER + SHE + SATISFIES + " +
                "HER + HATE + OFF + THOSE + FEARS + A + TASTE + RISES + AS + SHE + HEARS + THE + LEAST + FAR + " +
                "HORSE + THOSE + FAST + HORSES + THAT + FIRST + HEAR + THE + TROLL + FLEE + OFF + TO + THE + " +
                "FOREST + THE + HORSES + THAT + ALERTS + RAISE + THE + STARES + OF + THE + OTHERS + AS + THE + " +
                "TROLL + ASSAILS + AT + THE + TOTAL + SHIFT + HER + TEETH + TEAR + HOOF + OFF + TORSO + AS + THE + " +
                "LAST + HORSE + FORFEITS + ITS + LIFE + THE + FIRST + FATHERS + HEAR + OF + THE + HORRORS + THEIR + " +
                "FEARS + THAT + THE + FIRES + FOR + THEIR + FEASTS + ARREST + AS + THE + FIRST + FATHERS + " +
                "RESETTLE + THE + LAST + OF + THE + FIRE + HORSES + THE + LAST + TROLL + HARASSES + THE + FOREST + " +
                "HEART + FREE + AT + LAST + OF + THE + LAST + TROLL + ALL + OFFER + THEIR + FIRE + HEAT + TO + THE + " +
                "ASSISTERS + FAR + OFF + THE + TROLL + FASTS + ITS + LIFE + SHORTER + AS + STARS + RISE + THE + " +
                "HORSES + REST + SAFE + AFTER + ALL + SHARE + HOT + FISH + AS + THEIR + AFFILIATES + TAILOR + A + " +
                "ROOFS + FOR + THEIR + SAFE == FORTRESSES").solve())
                .containsOnly(
                        entry('A', 1),
                        entry('E', 0),
                        entry('F', 5),
                        entry('H', 8),
                        entry('I', 7),
                        entry('L', 2),
                        entry('O', 6),
                        entry('R', 3),
                        entry('S', 4),
                        entry('T', 9));
    }
}
