import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {

    @Test
    public void equilateralTriangleHaveEqualSides() throws Exception {
        Triangle triangle = new Triangle(2, 2, 2);

        assertEquals(triangle.getKind(), TriangleKind.EQUILATERAL);
    }

    @Test
    public void largerEquilateralTrianglesAlsoHaveEqualSides() throws Exception {
        Triangle triangle = new Triangle(10, 10, 10);

        assertEquals(triangle.getKind(), TriangleKind.EQUILATERAL);
    }

    @Test
    public void isoscelesTrianglesHaveLastTwoSidesEqual() throws Exception {
        Triangle triangle = new Triangle(3, 4, 4);

        assertEquals(triangle.getKind(), TriangleKind.ISOSCELES);
    }

    @Test
    public void isoscelesTrianglesHaveFirstAndLastSidesEqual() throws Exception {
        Triangle triangle = new Triangle(4, 3, 4);

        assertEquals(triangle.getKind(), TriangleKind.ISOSCELES);
    }

    @Test
    public void isoscelesTrianglesHaveTwoFirstSidesEqual() throws Exception {
        Triangle triangle = new Triangle(4, 4, 3);

        assertEquals(triangle.getKind(), TriangleKind.ISOSCELES);
    }

    @Test
    public void isoscelesTrianglesHaveInFactExactlyTwoSidesEqual() throws Exception {
        Triangle triangle = new Triangle(10, 10, 2);

        assertEquals(triangle.getKind(), TriangleKind.ISOSCELES);
    }

    @Test
    public void scaleneTrianglesHaveNoEqualSides() throws Exception {
        Triangle triangle = new Triangle(3, 4, 5);

        assertEquals(triangle.getKind(), TriangleKind.SCALENE);
    }

    @Test
    public void scaleneTrianglesHaveNoEqualSidesAtLargerScaleEither() throws Exception {
        Triangle triangle = new Triangle(10, 11, 12);

        assertEquals(triangle.getKind(), TriangleKind.SCALENE);
    }

    @Test
    public void scaleneTrianglesHaveNoEqualSidesInDescendingOrderEither() throws Exception {
        Triangle triangle = new Triangle(5, 4, 2);

        assertEquals(triangle.getKind(), TriangleKind.SCALENE);
    }

    @Test
    public void verySmallTrianglesAreLegal() throws Exception {
        Triangle triangle = new Triangle(0.4, 0.6, 0.3);

        assertEquals(triangle.getKind(), TriangleKind.SCALENE);
    }

    @Test(expected = TriangleException.class)
    public void trianglesWithNoSizeAreIllegal() throws Exception {
        new Triangle(0, 0, 0);
    }

    @Test(expected = TriangleException.class)
    public void trianglesWithNegativeSidesAreIllegal() throws Exception {
        new Triangle(3, 4, -5);
    }

    @Test(expected = TriangleException.class)
    public void trianglesViolatingTriangleInequalityAreIllegal() throws Exception {
        new Triangle(1, 1, 3);
    }

    @Test(expected = TriangleException.class)
    public void trianglesViolatingTriangleInequalityAreIllegal2() throws Exception {
        new Triangle(2, 4, 2);
    }

    @Test(expected = TriangleException.class)
    public void trianglesViolatingTriangleInequalityAreIllegal3() throws Exception {
        new Triangle(7, 3, 2);
    }
}
