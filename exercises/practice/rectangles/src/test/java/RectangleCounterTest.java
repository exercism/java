import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RectangleCounterTest {

    private RectangleCounter rectangleCounter;

    @BeforeEach
    public void setUp() {
        rectangleCounter = new RectangleCounter();
    }

    @Test
    public void testInputWithNoRowsContainsNoRectangles() {
        String[] inputGrid = new String[]{};

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInputWithNoColumnsContainsNoRectangles() {
        String[] inputGrid = new String[]{""};

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    public void testNonTrivialInputWithNoRectangles() {
        String[] inputGrid = new String[]{" "};

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
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
    public void testThatRectangleOfHeightOneIsCounted() {
        String[] inputGrid = new String[]{
            "+--+",
            "+--+"
        };

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
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
    public void testThatOneByOneSquareIsCounted() {
        String[] inputGrid = new String[]{
            "++",
            "++"
        };

        assertThat(rectangleCounter.countRectangles(inputGrid)).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
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
