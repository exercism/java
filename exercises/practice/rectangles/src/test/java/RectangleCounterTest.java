import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RectangleCounterTest {

    private RectangleCounter rectangleCounter;

    @BeforeEach
    public void setUp() {
        rectangleCounter = new RectangleCounter();
    }

    @Test
    @DisplayName("no rows")
    public void testInputWithNoRowsContainsNoRectangles() {
        String[] inputGrid = new String[]{};

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no columns")
    public void testInputWithNoColumnsContainsNoRectangles() {
        String[] inputGrid = new String[]{""};

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no rectangles")
    public void testNonTrivialInputWithNoRectangles() {
        String[] inputGrid = new String[]{" "};

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("one rectangle")
    public void testInputWithOneRectangle() {
        String[] inputGrid = new String[]{
            "+-+",
            "| |",
            "+-+"
        };

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two rectangles without shared parts")
    public void testInputWithTwoRectanglesWithoutSharedEdges() {
        String[] inputGrid = new String[]{
            "  +-+",
            "  | |",
            "+-+-+",
            "| |  ",
            "+-+  "
        };

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("five rectangles with shared parts")
    public void testInputWithFiveRectanglesWithSharedEdges() {
        String[] inputGrid = new String[]{
            "  +-+",
            "  | |",
            "+-+-+",
            "| | |",
            "+-+-+"
        };

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(5);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("rectangle of height 1 is counted")
    public void testThatRectangleOfHeightOneIsCounted() {
        String[] inputGrid = new String[]{
            "+--+",
            "+--+"
        };

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("rectangle of width 1 is counted")
    public void testThatRectangleOfWidthOneIsCounted() {
        String[] inputGrid = new String[]{
            "++",
            "||",
            "++"
        };

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("1x1 square is counted")
    public void testThatOneByOneSquareIsCounted() {
        String[] inputGrid = new String[]{
            "++",
            "++"
        };

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("only complete rectangles are counted")
    public void testThatIncompleteRectanglesAreNotCounted() {
        String[] inputGrid = new String[]{
            "  +-+",
            "    |",
            "+-+-+",
            "| | -",
            "+-+-+"
        };

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("rectangles can be of different sizes")
    public void testThatRectanglesOfDifferentSizesAreAllCounted() {
        String[] inputGrid = new String[]{
            "+------+----+",
            "|      |    |",
            "+---+--+    |",
            "|   |       |",
            "+---+-------+"
        };

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("corner is required for a rectangle to be complete")
    public void testThatIntersectionsWithoutCornerCharacterDoNotCountAsRectangleCorners() {
        String[] inputGrid = new String[]{
            "+------+----+",
            "|      |    |",
            "+------+    |",
            "|   |       |",
            "+---+-------+"
        };

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("large input with many rectangles")
    public void testLargeInputWithManyRectangles() {
        String[] inputGrid = new String[]{
            "+---+--+----+",
            "|   +--+----+",
            "+---+--+    |",
            "|   +--+----+",
            "+---+--+--+-+",
            "+---+--+--+-+",
            "+------+  | |",
            "          +-+"
        };

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(60);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("rectangles must have four sides")
    public void testRectanglesMustHaveFourSides() {
        String[] inputGrid = new String[]{
            "+-+ +-+",
            "| | | |",
            "+-+-+-+",
            "  | |  ",
            "+-+-+-+",
            "| | | |",
            "+-+ +-+"
        };

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(5);
    }
}
