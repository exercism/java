import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
 * version: 1.0.0
 */
public class MinesweeperBoardTest {

    @Test
    public void testInputBoardWithNoRowsAndNoColumns() {
        final List<String> inputBoard = Collections.emptyList();
        final List<String> expectedNumberedBoard = Collections.emptyList();
        final List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithOneRowAndNoColumns() {
        final List<String> inputBoard = Collections.singletonList("");
        final List<String> expectedNumberedBoard = Collections.singletonList("");
        final List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithNoMines() {
        final List<String> inputBoard = Arrays.asList(
                "   ",
                "   ",
                "   "
        );

        final List<String> expectedNumberedBoard = Arrays.asList(
                "   ",
                "   ",
                "   "
        );

        final List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithOnlyMines() {
        final List<String> inputBoard = Arrays.asList(
                "***",
                "***",
                "***"
        );

        final List<String> expectedNumberedBoard = Arrays.asList(
                "***",
                "***",
                "***"
        );

        final List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithSingleMineAtCenter() {
        final List<String> inputBoard = Arrays.asList(
                "   ",
                " * ",
                "   "
        );

        final List<String> expectedNumberedBoard = Arrays.asList(
                "111",
                "1*1",
                "111"
        );

        final List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithMinesAroundPerimeter() {
        final List<String> inputBoard = Arrays.asList(
                "***",
                "* *",
                "***"
        );

        final List<String> expectedNumberedBoard = Arrays.asList(
                "***",
                "*8*",
                "***"
        );

        final List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithSingleRowAndTwoMines() {
        final List<String> inputBoard = Collections.singletonList(
                " * * "
        );

        final List<String> expectedNumberedBoard = Collections.singletonList(
                "1*2*1"
        );

        final List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithSingleRowAndTwoMinesAtEdges() {
        final List<String> inputBoard = Collections.singletonList(
                "*   *"
        );

        final List<String> expectedNumberedBoard = Collections.singletonList(
                "*1 1*"
        );

        final List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithSingleColumnAndTwoMines() {
        final List<String> inputBoard = Arrays.asList(
                " ",
                "*",
                " ",
                "*",
                " "
        );

        final List<String> expectedNumberedBoard = Arrays.asList(
                "1",
                "*",
                "2",
                "*",
                "1"
        );

        final List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithSingleColumnAndTwoMinesAtEdges() {
        final List<String> inputBoard = Arrays.asList(
                "*",
                " ",
                " ",
                " ",
                "*"
        );

        final List<String> expectedNumberedBoard = Arrays.asList(
                "*",
                "1",
                " ",
                "1",
                "*"
        );

        final List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInputBoardWithMinesInCross() {
        final List<String> inputBoard = Arrays.asList(
                "  *  ",
                "  *  ",
                "*****",
                "  *  ",
                "  *  "
        );

        final List<String> expectedNumberedBoard = Arrays.asList(
                " 2*2 ",
                "25*52",
                "*****",
                "25*52",
                " 2*2 "
        );

        final List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargeInputBoard() {
        final List<String> inputBoard = Arrays.asList(
                " *  * ",
                "  *   ",
                "    * ",
                "   * *",
                " *  * ",
                "      "
        );

        final List<String> expectedNumberedBoard = Arrays.asList(
                "1*22*1",
                "12*322",
                " 123*2",
                "112*4*",
                "1*22*2",
                "111111"
        );

        final List<String> actualNumberedBoard = new MinesweeperBoard(inputBoard).withNumbers();

        assertEquals(expectedNumberedBoard, actualNumberedBoard);
    }

}
