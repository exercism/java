import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PiecingItTogetherTest {
    private static final double DOUBLE_EQUALITY_TOLERANCE = 1e-9;

    @Test
    public void test1000PiecesWithAspectRatio() {
        JigsawInfo input = new JigsawInfo.Builder()
                .pieces(1000)
                .aspectRatio(1.6)
                .build();

        JigsawInfo expected = new JigsawInfo.Builder()
                .pieces(1000)
                .border(126)
                .inside(874)
                .rows(25)
                .columns(40)
                .aspectRatio(1.6)
                .format("landscape")
                .build();

        JigsawInfo actual = PiecingItTogether.getCompleteInformation(input);
        assertJigsawInfoEquals(actual, expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSquarePuzzleWith32Rows() {
        JigsawInfo input = new JigsawInfo.Builder()
                .rows(32)
                .format("square")
                .build();

        JigsawInfo expected = new JigsawInfo.Builder()
                .pieces(1024)
                .border(124)
                .inside(900)
                .rows(32)
                .columns(32)
                .aspectRatio(1.0)
                .format("square")
                .build();

        JigsawInfo actual = PiecingItTogether.getCompleteInformation(input);
        assertJigsawInfoEquals(actual, expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInsideAndAspectRatioOnly() {
        JigsawInfo input = new JigsawInfo.Builder()
                .inside(324)
                .aspectRatio(1.0)
                .build();

        JigsawInfo expected = new JigsawInfo.Builder()
                .pieces(400)
                .border(76)
                .inside(324)
                .rows(20)
                .columns(20)
                .aspectRatio(1.0)
                .format("square")
                .build();

        JigsawInfo actual = PiecingItTogether.getCompleteInformation(input);
        assertJigsawInfoEquals(actual, expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLandscape1500WithRowsAndAspect() {
        JigsawInfo input = new JigsawInfo.Builder()
                .rows(30)
                .aspectRatio(1.6666666666666667)
                .build();

        JigsawInfo expected = new JigsawInfo.Builder()
                .pieces(1500)
                .border(156)
                .inside(1344)
                .rows(30)
                .columns(50)
                .aspectRatio(1.6666666666666667)
                .format("landscape")
                .build();

        JigsawInfo actual = PiecingItTogether.getCompleteInformation(input);
        assertJigsawInfoEquals(actual, expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void test300PiecesPortraitWithBorder() {
        JigsawInfo input = new JigsawInfo.Builder()
                .pieces(300)
                .border(70)
                .format("portrait")
                .build();

        JigsawInfo expected = new JigsawInfo.Builder()
                .pieces(300)
                .border(70)
                .inside(230)
                .rows(25)
                .columns(12)
                .aspectRatio(0.48)
                .format("portrait")
                .build();

        JigsawInfo actual = PiecingItTogether.getCompleteInformation(input);
        assertJigsawInfoEquals(actual, expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInsufficientData() {
        JigsawInfo input = new JigsawInfo.Builder()
                .pieces(1500)
                .format("landscape")
                .build();

        assertThatThrownBy(() -> PiecingItTogether.getCompleteInformation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Insufficient data");
    }

    @Disabled("Remove to run test")
    @Test
    public void testContradictoryData() {
        JigsawInfo input = new JigsawInfo.Builder()
                .rows(100)
                .columns(1000)
                .format("square")
                .build();

        assertThatThrownBy(() -> PiecingItTogether.getCompleteInformation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Contradictory data");
    }

    /**
     * Helper to compare two JigsawInfo objects,
     * allowing a small tolerance when comparing aspect ratio doubles.
     */
    private void assertJigsawInfoEquals(JigsawInfo actual, JigsawInfo expected) {
        assertThat(actual.getPieces()).isEqualTo(expected.getPieces());
        assertThat(actual.getBorder()).isEqualTo(expected.getBorder());
        assertThat(actual.getInside()).isEqualTo(expected.getInside());
        assertThat(actual.getRows()).isEqualTo(expected.getRows());
        assertThat(actual.getColumns()).isEqualTo(expected.getColumns());
        assertThat(actual.getFormat()).isEqualTo(expected.getFormat());

        Double actualAspect = actual.getAspectRatio().orElseThrow(() -> new AssertionError("Missing aspect ratio in actual result"));
        Double expectedAspect = expected.getAspectRatio().orElseThrow(() -> new AssertionError("Missing aspect ratio in expected result"));

        assertThat(actualAspect).isCloseTo(expectedAspect, org.assertj.core.api.Assertions.within(DOUBLE_EQUALITY_TOLERANCE));
    }
}
