import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PiecingItTogetherTest {
    private PiecingItTogether solver;
    private double epsilon;

    @BeforeEach
    public void setup() {
        solver = new PiecingItTogether();
        epsilon = 1e-6;
    }

    @Test
    public void test1000PiecesWithAspectRatio() {
        PartialJigsawInformation input = new PartialJigsawInformation(1000, null, null, null, null, 1.6, null);
        PartialJigsawInformation expected = new PartialJigsawInformation(1000, 126, 874, 25, 40, 1.6, "landscape");

        PartialJigsawInformation actual = solver.getCompleteInformation(input);
        assertJigsawEqualsWithTolerance(actual, expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSquarePuzzleWith32Rows() {
        PartialJigsawInformation input = new PartialJigsawInformation(null, null, null, 32, null, null, "square");
        PartialJigsawInformation expected = new PartialJigsawInformation(1024, 124, 900, 32, 32, 1.0, "square");

        PartialJigsawInformation actual = solver.getCompleteInformation(input);
        assertJigsawEqualsWithTolerance(actual, expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInsideAndAspectRatioOnly() {
        PartialJigsawInformation input = new PartialJigsawInformation(null, null, 324, null, null, 1.0, null);
        PartialJigsawInformation expected = new PartialJigsawInformation(400, 76, 324, 20, 20, 1.0, "square");

        PartialJigsawInformation actual = solver.getCompleteInformation(input);
        assertJigsawEqualsWithTolerance(actual, expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLandscape1500WithRowsAndAspect() {
        PartialJigsawInformation input = new PartialJigsawInformation(null, null, null, 30, null, 1.6666666666666667, null);
        PartialJigsawInformation expected = new PartialJigsawInformation(1500, 156, 1344, 30, 50, 1.6666666666666667, "landscape");

        PartialJigsawInformation actual = solver.getCompleteInformation(input);
        assertJigsawEqualsWithTolerance(actual, expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void test300PiecesPortraitWithBorder() {
        PartialJigsawInformation input = new PartialJigsawInformation(300, 70, null, null, null, null, "portrait");
        PartialJigsawInformation expected = new PartialJigsawInformation(300, 70, 230, 25, 12, 0.48, "portrait");

        PartialJigsawInformation actual = solver.getCompleteInformation(input);
        assertJigsawEqualsWithTolerance(actual, expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInsufficientData() {
        PartialJigsawInformation input = new PartialJigsawInformation(1500, null, null, null, null, null, "landscape");

        assertThatThrownBy(() -> solver.getCompleteInformation(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Insufficient data");
    }

    @Disabled("Remove to run test")
    @Test
    public void testContradictoryData() {
        PartialJigsawInformation input = new PartialJigsawInformation(null, null, null, 100, 1000, null, "square");

        assertThatThrownBy(() -> solver.getCompleteInformation(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Contradictory data");
    }

    /**
     * Helper to compare two PartialJigsawInformation objects,
     * allowing a small tolerance when comparing aspect ratio doubles.
     */
    private void assertJigsawEqualsWithTolerance(PartialJigsawInformation actual, PartialJigsawInformation expected) {
        assertThat(actual.getPieces()).isEqualTo(expected.getPieces());
        assertThat(actual.getBorder()).isEqualTo(expected.getBorder());
        assertThat(actual.getInside()).isEqualTo(expected.getInside());
        assertThat(actual.getRows()).isEqualTo(expected.getRows());
        assertThat(actual.getColumns()).isEqualTo(expected.getColumns());
        assertThat(actual.getFormat()).isEqualTo(expected.getFormat());

        Double actualAspect = actual.getAspectRatio().orElseThrow(() -> new AssertionError("Missing aspect ratio in actual result"));
        Double expectedAspect = expected.getAspectRatio().orElseThrow(() -> new AssertionError("Missing aspect ratio in expected result"));

        assertThat(actualAspect).isCloseTo(expectedAspect, org.assertj.core.api.Assertions.within(epsilon));
    }
}
