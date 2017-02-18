import org.junit.Test;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TriangleTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void equilateralTriangleHaveEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(2, 2, 2);

        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
    }

    @Ignore
    @Test
    public void largerEquilateralTrianglesAlsoHaveEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(10, 10, 10);

        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
    }

    @Ignore
    @Test
    public void isoscelesTrianglesHaveLastTwoSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(3, 4, 4);

        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Ignore
    @Test
    public void isoscelesTrianglesHaveFirstAndLastSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(4, 3, 4);

        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Ignore
    @Test
    public void isoscelesTrianglesHaveTwoFirstSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 3);

        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Ignore
    @Test
    public void isoscelesTrianglesHaveInFactExactlyTwoSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(10, 10, 2);

        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Ignore
    @Test
    public void scaleneTrianglesHaveNoEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(3, 4, 5);

        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @Ignore
    @Test
    public void scaleneTrianglesHaveNoEqualSidesAtLargerScaleEither() throws TriangleException {
        Triangle triangle = new Triangle(10, 11, 12);

        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @Ignore
    @Test
    public void scaleneTrianglesHaveNoEqualSidesInDescendingOrderEither() throws TriangleException {
        Triangle triangle = new Triangle(5, 4, 2);

        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @Ignore
    @Test
    public void verySmallTrianglesAreLegal() throws TriangleException {
        Triangle triangle = new Triangle(0.4, 0.6, 0.3);

        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @Ignore
    @Test
    public void trianglesWithNoSizeAreIllegal() throws TriangleException {
        thrown.expect(TriangleException.class);
        new Triangle(0, 0, 0);
    }

    @Ignore
    @Test
    public void trianglesWithNegativeSidesAreIllegal() throws TriangleException {
        thrown.expect(TriangleException.class);
        new Triangle(3, 4, -5);
    }

    @Ignore
    @Test
    public void trianglesViolatingTriangleInequalityAreIllegal() throws TriangleException {
        thrown.expect(TriangleException.class);
        new Triangle(1, 1, 3);
    }

    @Ignore
    @Test
    public void trianglesViolatingTriangleInequalityAreIllegal2() throws TriangleException {
        thrown.expect(TriangleException.class);
        new Triangle(2, 4, 2);
    }

    @Ignore
    @Test
    public void trianglesViolatingTriangleInequalityAreIllegal3() throws TriangleException {
        thrown.expect(TriangleException.class);
        new Triangle(7, 3, 2);
    }
}
