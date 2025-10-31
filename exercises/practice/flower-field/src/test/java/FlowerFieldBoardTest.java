import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FlowerFieldBoardTest {

    @Test
    @DisplayName("no rows")
    public void testInputBoardWithNoRowsAndNoColumns() {
        List<String> inputBoard = Collections.emptyList();
        List<String> expectedNumberedBoard = Collections.emptyList();
        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no columns")
    public void testInputBoardWithOneRowAndNoColumns() {
        List<String> inputBoard = List.of("");
        List<String> expectedNumberedBoard = List.of("");
        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no flowers")
    public void testInputBoardWithNoFlowers() {
        List<String> inputBoard = List.of(
                "   ",
                "   ",
                "   "
        );

        List<String> expectedNumberedBoard = List.of(
                "   ",
                "   ",
                "   "
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("garden full of flowers")
    public void testInputBoardWithOnlyFlowers() {
        List<String> inputBoard = List.of(
                "***",
                "***",
                "***"
        );

        List<String> expectedNumberedBoard = List.of(
                "***",
                "***",
                "***"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("flower surrounded by spaces")
    public void testInputBoardWithSingleFlowerAtCenter() {
        List<String> inputBoard = List.of(
                "   ",
                " * ",
                "   "
        );

        List<String> expectedNumberedBoard = List.of(
                "111",
                "1*1",
                "111"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("space surrounded by flowers")
    public void testInputBoardWithFlowersAroundPerimeter() {
        List<String> inputBoard = List.of(
                "***",
                "* *",
                "***"
        );

        List<String> expectedNumberedBoard = List.of(
                "***",
                "*8*",
                "***"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("horizontal line")
    public void testInputBoardWithSingleRowAndTwoFlowers() {
        List<String> inputBoard = List.of(
                " * * "
        );

        List<String> expectedNumberedBoard = List.of(
                "1*2*1"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("horizontal line, flowers at edges")
    public void testInputBoardWithSingleRowAndTwoFlowersAtEdges() {
        List<String> inputBoard = List.of(
                "*   *"
        );

        List<String> expectedNumberedBoard = List.of(
                "*1 1*"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("vertical line")
    public void testInputBoardWithSingleColumnAndTwoFlowers() {
        List<String> inputBoard = List.of(
                " ",
                "*",
                " ",
                "*",
                " "
        );

        List<String> expectedNumberedBoard = List.of(
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
    @DisplayName("vertical line, flowers at edges")
    public void testInputBoardWithSingleColumnAndTwoFlowersAtEdges() {
        List<String> inputBoard = List.of(
                "*",
                " ",
                " ",
                " ",
                "*"
        );

        List<String> expectedNumberedBoard = List.of(
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
    @DisplayName("cross")
    public void testInputBoardWithFlowersInCross() {
        List<String> inputBoard = List.of(
                "  *  ",
                "  *  ",
                "*****",
                "  *  ",
                "  *  "
        );

        List<String> expectedNumberedBoard = List.of(
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
    @DisplayName("large garden")
    public void testLargeInputBoard() {
        List<String> inputBoard = List.of(
                " *  * ",
                "  *   ",
                "    * ",
                "   * *",
                " *  * ",
                "      "
        );

        List<String> expectedNumberedBoard = List.of(
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

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple adjacent flowers")
    public void testMultipleAdjacentFlowers() {
        List<String> inputBoard = List.of(
                " ** "
        );

        List<String> expectedNumberedBoard = List.of(
                "1**1"
        );

        List<String> actualNumberedBoard = new FlowerFieldBoard(inputBoard).withNumbers();

        assertThat(actualNumberedBoard).isEqualTo(expectedNumberedBoard);
    }
}
