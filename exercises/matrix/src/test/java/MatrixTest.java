import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MatrixTest {
	
	@Test
	public void ExtractRowFromOneNumberMatrixTest() {
		String matrixAsString = "1";
		int rowIndex = 0;
		int[] row = {1};
		
		Matrix matrix = new Matrix(matrixAsString);
		
		assertArrayEquals(row, matrix.getRow(rowIndex));
	}
	
	@Test
	public void ExtractRowFromMatrixTest() {
		String matrixAsString = "1 2\n3 4";
		int rowIndex = 1;
		int[] row = {3, 4};
		
		Matrix matrix = new Matrix(matrixAsString);
		
		assertArrayEquals(row, matrix.getRow(rowIndex));
	}
	
	@Test
	public void ExtractRowFromDiffWidthsMatrixTest() {
		String matrixAsString = "1 2\n10 20";
		int rowIndex = 1;
		int[] row = {10, 20};
		
		Matrix matrix = new Matrix(matrixAsString);
		
		assertArrayEquals(row, matrix.getRow(rowIndex));
	}
	
	@Test
	public void ExtractRowFromNonSquareMatrixTest() {
		String matrixAsString = "1 2 3\n4 5 6\n7 8 9\n8 7 6";
		int rowIndex = 2;
		int[] row = {7, 8, 9};
		
		Matrix matrix = new Matrix(matrixAsString);
		
		assertArrayEquals(row, matrix.getRow(rowIndex));
	}
	
	@Test
	public void ExtractColumnFromOneNumberMatrixTest() {
		String matrixAsString = "1";
		int columnIndex = 0;
		int[] column = {1};
		
		Matrix matrix = new Matrix(matrixAsString);
		
		assertArrayEquals(column, matrix.getColumn(columnIndex));
	}
	
	@Test
	public void ExtractColumnMatrixTest() {
		String matrixAsString = "1 2 3\n4 5 6\n7 8 9";
		int columnIndex = 2;
		int[] column = {3, 6, 9};
		
		Matrix matrix = new Matrix(matrixAsString);
		
		assertArrayEquals(column, matrix.getColumn(columnIndex));
	}
	
	@Test
	public void ExtractColumnFromNonSquareMatrixTest() {
		String matrixAsString = "1 2 3\n4 5 6\n7 8 9\n8 7 6";
		int columnIndex = 2;
		int[] column = {3, 6, 9, 6};
		
		Matrix matrix = new Matrix(matrixAsString);
		
		assertArrayEquals(column, matrix.getColumn(columnIndex));
	}
	
	@Test
	public void ExtractColumnFromDiffWidthsMatrixTest() {
		String matrixAsString = "89 1903 3\n18 3 1\n9 4 800";
		int columnIndex = 1;
		int[] column = {1903, 3, 4};
		
		Matrix matrix = new Matrix(matrixAsString);
		
		assertArrayEquals(column, matrix.getColumn(columnIndex));
	}
}
