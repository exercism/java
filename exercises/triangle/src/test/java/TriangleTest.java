import org.junit.Test;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TriangleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void equilateralTrianglesHaveEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(2, 2, 2);

        assertEquals(true, triangle.isEquilateral());
    }

    @Ignore("Remove to run test")
    @Test
    public void largerEquilateralTrianglesAlsoHaveEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(10, 10, 10);

        assertEquals(true, triangle.isEquilateral());
    }

    @Ignore("Remove to run test")
    @Test
    public void isoscelesTrianglesHaveLastTwoSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(3, 4, 4);

        assertEquals(true, triangle.isIsosceles());
    }

    @Ignore("Remove to run test")
    @Test
    public void isoscelesTrianglesHaveFirstAndLastSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(4, 3, 4);

        assertEquals(true, triangle.isIsosceles());
    }

    @Ignore("Remove to run test")
    @Test
    public void isoscelesTrianglesHaveTwoFirstSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 3);

        assertEquals(true, triangle.isIsosceles());
    }

    @Ignore("Remove to run test")
    @Test
    public void isoscelesTrianglesHaveInFactExactlyTwoSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(10, 10, 2);

        assertEquals(true, triangle.isIsosceles());
    }

    @Ignore("Remove to run test")
    @Test
    public void scaleneTrianglesHaveNoEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(3, 4, 5);

        assertEquals(true, triangle.isScalene());
    }

    @Ignore("Remove to run test")
    @Test
    public void scaleneTrianglesHaveNoEqualSidesAtLargerScaleEither() throws TriangleException {
        Triangle triangle = new Triangle(10, 11, 12);

        assertEquals(true, triangle.isScalene());
    }

    @Ignore("Remove to run test")
    @Test
    public void scaleneTrianglesHaveNoEqualSidesInDescendingOrderEither() throws TriangleException {
        Triangle triangle = new Triangle(5, 4, 2);

        assertEquals(true, triangle.isScalene());
    }

    @Ignore("Remove to run test")
    @Test
    public void verySmallTrianglesAreLegal() throws TriangleException {
        Triangle triangle = new Triangle(0.4, 0.6, 0.3);

        assertEquals(true, triangle.isScalene());
    }

    @Ignore("Remove to run test")
    @Test
    public void trianglesWithNoSizeAreIllegal() throws TriangleException {
        expectedException.expect(TriangleException.class);
        new Triangle(0, 0, 0);
    }

    @Ignore("Remove to run test")
    @Test
    public void trianglesWithNegativeSidesAreIllegal() throws TriangleException {
        expectedException.expect(TriangleException.class);
        new Triangle(3, 4, -5);
    }

    @Ignore("Remove to run test")
    @Test
    public void trianglesViolatingTriangleInequalityAreIllegal() throws TriangleException {
        expectedException.expect(TriangleException.class);
        new Triangle(1, 1, 3);
    }

    @Ignore("Remove to run test")
    @Test
    public void trianglesViolatingTriangleInequalityAreIllegal2() throws TriangleException {
        expectedException.expect(TriangleException.class);
        new Triangle(2, 5, 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void trianglesViolatingTriangleInequalityAreIllegal3() throws TriangleException {
        expectedException.expect(TriangleException.class);
        new Triangle(7, 3, 2);
    }
}
