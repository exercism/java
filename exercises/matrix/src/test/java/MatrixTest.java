import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class MatrixTest {

    @RunWith(Parameterized.class)
    public static class CountRowsTest {
        private Matrix matrix;
        private int numberOfRows;

        @Parameterized.Parameters(name = "{index}: expected matrix constructed with string \n\"{0}\" to have {1} row(s).")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"0", 1},
                    {"0 1", 1},
                    {  "0\n"
                     + "1", 2},
                    {  "0 1\n"
                     + "2 3", 2},
                    {  "0 1 2\n"
                     + "3 4 5\n"
                     + "6 7 8", 3}
            });
        }

        public CountRowsTest(String matrixAsString, int numberOfRows) {
            this.matrix = new Matrix(matrixAsString);
            this.numberOfRows = numberOfRows;
        }

        @Test
        public void countRowsTest() {
            assertEquals(numberOfRows, matrix.getRowsCount());
        }
    }

    @Ignore
    @RunWith(Parameterized.class)
    public static class CountColumnsTest {
        private Matrix matrix;
        private int numberOfColumns;

        @Parameterized.Parameters(name = "{index}: expected matrix constructed with string \n\"{0}\" to have {1} column(s).")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"0", 1},
                    {"0 1", 2},
                    {  "0\n"
                     + "1", 1},
                    {  "0 1\n"
                     + "2 3", 2},
                    {  "0 1 2\n"
                     + "3 4 5\n"
                     + "6 7 8", 3}
            });
        }

        public CountColumnsTest(String matrixAsString, int numberOfColumns) {
            this.matrix = new Matrix(matrixAsString);
            this.numberOfColumns = numberOfColumns;
        }

        @Test
        public void countColumnsTest() {
            assertEquals(numberOfColumns, matrix.getColumnsCount());
        }
    }

    @Ignore
    @RunWith(Parameterized.class)
    public static class GetFirstRowTest {
        private Matrix matrix;
        private int[] firstRow;

        @Parameterized.Parameters(name = "{index}: checking first row of matrix constructed with string \n\"{0}\".")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"0", new int[] {0}},
                    {"0 1", new int[] {0, 1}},
                    {  "0\n"
                     + "1", new int[] {0}},
                    {  "0 1\n"
                     + "2 3", new int[] {0, 1}},
                    {  "0 1 2\n"
                     + "3 4 5\n"
                     + "6 7 8", new int[] {0, 1, 2}}
            });
        }

        public GetFirstRowTest(String matrixAsString, int[] firstRow) {
            this.matrix = new Matrix(matrixAsString);
            this.firstRow = firstRow;
        }

        @Test
        public void getFirstRowTest() {
            assertArrayEquals(firstRow, matrix.getRow(0));
        }
    }

    @Ignore
    @RunWith(Parameterized.class)
    public static class GetLastRowTest {
        private Matrix matrix;
        private int[] lastRow;

        @Parameterized.Parameters(name = "{index}: checking last row of matrix constructed with string \n\"{0}\".")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"0", new int[] {0}},
                    {"0 1", new int[] {0, 1}},
                    {  "0\n"
                     + "1", new int[] {1}},
                    {  "0 1\n"
                     + "2 3", new int[] {2, 3}},
                    {  "0 1 2\n"
                     + "3 4 5\n"
                     + "6 7 8", new int[] {6, 7, 8}}
            });
        }

        public GetLastRowTest(String matrixAsString, int[] lastRow) {
            this.matrix = new Matrix(matrixAsString);
            this.lastRow = lastRow;
        }

        @Test
        public void getLastRowTest() {
            assertArrayEquals(lastRow, matrix.getRow(matrix.getRowsCount() - 1));
        }
    }

    @Ignore
    @RunWith(Parameterized.class)
    public static class GetFirstColumnTest {
        private Matrix matrix;
        private int[] firstColumn;

        @Parameterized.Parameters(name = "{index}: checking first column of matrix constructed with string \n\"{0}\".")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"0", new int[] {0}},
                    {"0 1", new int[] {0}},
                    {  "0\n"
                     + "1", new int[] {0, 1}},
                    {  "0 1\n"
                     + "2 3", new int[] {0, 2}},
                    {  "0 1 2\n"
                     + "3 4 5\n"
                     + "6 7 8", new int[] {0, 3, 6}}
            });
        }

        public GetFirstColumnTest(String matrixAsString, int[] firstColumn) {
            this.matrix = new Matrix(matrixAsString);
            this.firstColumn = firstColumn;
        }

        @Test
        public void getFirstColumnTest() {
            assertArrayEquals(firstColumn, matrix.getColumn(0));
        }
    }


    @Ignore
    @RunWith(Parameterized.class)
    public static class GetLastColumnTest {
        private Matrix matrix;
        private int[] lastColumn;

        @Parameterized.Parameters(name = "{index}: checking last column of matrix constructed with string \n\"{0}\".")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"0", new int[] {0}},
                    {"0 1", new int[] {1}},
                    {  "0\n"
                     + "1", new int[] {0, 1}},
                    {  "0 1\n"
                     + "2 3", new int[] {1, 3}},
                    {  "0 1 2\n"
                     + "3 4 5\n"
                     + "6 7 8", new int[] {2, 5, 8}}
            });
        }

        public GetLastColumnTest(String matrixAsString, int[] lastColumn) {
            this.matrix = new Matrix(matrixAsString);
            this.lastColumn = lastColumn;
        }

        @Test
        public void getLastColumnTest() {
            assertArrayEquals(lastColumn, matrix.getColumn(matrix.getColumnsCount() - 1));
        }
    }
}
