import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    @Test
    public void testCanIdentifySingleSaddlePoint() {
        Matrix matrix = new Matrix(Arrays.asList(
            Arrays.asList(9, 8, 7),
            Arrays.asList(5, 3, 2),
            Arrays.asList(6, 6, 7)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = Collections.singleton(new MatrixCoordinate(1, 0));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCanIdentifyThatEmptyMatrixHasNoSaddlePoints() {
        Matrix matrix = new Matrix(new ArrayList<>());

        Set<MatrixCoordinate> expectedSaddlePoints = Collections.emptySet();

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCanIdentifyLackOfSaddlePointsWhenThereAreNone() {
        Matrix matrix = new Matrix(Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(3, 1, 2),
            Arrays.asList(2, 3, 1)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = Collections.emptySet();

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCanIdentifyMultipleSaddlePoints() {
        Matrix matrix = new Matrix(Arrays.asList(
            Arrays.asList(4, 5, 4),
            Arrays.asList(3, 5, 5),
            Arrays.asList(1, 5, 4)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = new HashSet<>(Arrays.asList(
            new MatrixCoordinate(0, 1),
            new MatrixCoordinate(1, 1),
            new MatrixCoordinate(2, 1)
        ));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCanIdentifySaddlePointInBottomRightCorner() {
        Matrix matrix = new Matrix(Arrays.asList(
            Arrays.asList(8, 7, 9),
            Arrays.asList(6, 7, 6),
            Arrays.asList(3, 2, 5)
        ));

        Set<MatrixCoordinate> expectedSaddlePoints = Collections.singleton(new MatrixCoordinate(2, 2));

        assertEquals(expectedSaddlePoints, matrix.getSaddlePoints());
    }

}
