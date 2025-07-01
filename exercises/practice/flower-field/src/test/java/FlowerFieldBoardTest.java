import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FlowerFieldBoardTest {

    @Test
    public void testInputBoardWithNoRowsAndNoColumns() {
        List<String> inputBoard = Collections.emptyList();
        List<String> expectedNumberedBoard = Collections.emptyList();
        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInputBoardWithOneRowAndNoColumns() {
        List<String> inputBoard = Collections.singletonList("");
        List<String> expectedNumberedBoard = Collections.singletonList("");
        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInputBoardWithNoFlowers() {
        List<String> inputBoard = Arrays.asList(
                "   ",
                "   ",
                "   "
        );

        List<String> expectedNumberedBoard = Arrays.asList(
                "   ",
                "   ",
                "   "
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInputBoardWithOnlyFlowers() {
        List<String> inputBoard = Arrays.asList(
                "***",
                "***",
                "***"
        );

        List<String> expectedNumberedBoard = Arrays.asList(
                "***",
                "***",
                "***"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInputBoardWithSingleFlowerAtCenter() {
        List<String> inputBoard = Arrays.asList(
                "   ",
                " * ",
                "   "
        );

        List<String> expectedNumberedBoard = Arrays.asList(
                "111",
                "1*1",
                "111"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInputBoardWithFlowersAroundPerimeter() {
        List<String> inputBoard = Arrays.asList(
                "***",
                "* *",
                "***"
        );

        List<String> expectedNumberedBoard = Arrays.asList(
                "***",
                "*8*",
                "***"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInputBoardWithSingleRowAndTwoFlowers() {
        List<String> inputBoard = Collections.singletonList(
                " * * "
        );

        List<String> expectedNumberedBoard = Collections.singletonList(
                "1*2*1"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInputBoardWithSingleRowAndTwoFlowersAtEdges() {
        List<String> inputBoard = Collections.singletonList(
                "*   *"
        );

        List<String> expectedNumberedBoard = Collections.singletonList(
                "*1 1*"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInputBoardWithSingleColumnAndTwoFlowers() {
        List<String> inputBoard = Arrays.asList(
                " ",
                "*",
                " ",
                "*",
                " "
        );

        List<String> expectedNumberedBoard = Arrays.asList(
                "1",
                "*",
                "2",
                "*",
                "1"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInputBoardWithSingleColumnAndTwoFlowersAtEdges() {
        List<String> inputBoard = Arrays.asList(
                "*",
                " ",
                " ",
                " ",
                "*"
        );

        List<String> expectedNumberedBoard = Arrays.asList(
                "*",
                "1",
                " ",
                "1",
                "*"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    public void testInputBoardWithFlowersInCross() {
        List<String> inputBoard = Arrays.asList(
                "  *  ",
                "  *  ",
                "*****",
                "  *  ",
                "  *  "
        );

        List<String> expectedNumberedBoard = Arrays.asList(
                " 2*2 ",
                "25*52",
                "*****",
                "25*52",
                " 2*2 "
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLargeInputBoard() {
        List<String> inputBoard = Arrays.asList(
                " *  * ",
                "  *   ",
                "    * ",
                "   * *",
                " *  * ",
                "      "
        );

        List<String> expectedNumberedBoard = Arrays.asList(
                "1*22*1",
                "12*322",
                " 123*2",
                "112*4*",
                "1*22*2",
                "111111"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

}
