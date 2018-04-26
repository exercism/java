import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MinesweeperBoardTest {

    @Test
    public void testInputBoardWithNoRowsAndNoColumns() {
        List<String> inputBoard = Collections.emptyList();
        List<String> expectedNumberedBoard = Collections.emptyList();
        List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithOneRowAndNoColumns() {
        List<String> inputBoard = Collections.singletonList("");
        List<String> expectedNumberedBoard = Collections.singletonList("");
        List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithNoMines() {
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

        List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithOnlyMines() {
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

        List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithSingleMineAtCenter() {
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

        List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithMinesAroundPerimeter() {
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

        List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithSingleRowAndTwoMines() {
        List<String> inputBoard = Collections.singletonList(
                " * * "
        );

        List<String> expectedNumberedBoard = Collections.singletonList(
                "1*2*1"
        );

        List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithSingleRowAndTwoMinesAtEdges() {
        List<String> inputBoard = Collections.singletonList(
                "*   *"
        );

        List<String> expectedNumberedBoard = Collections.singletonList(
                "*1 1*"
        );

        List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithSingleColumnAndTwoMines() {
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

        List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithSingleColumnAndTwoMinesAtEdges() {
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

        List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithMinesInCross() {
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

        List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
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

        List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

}
