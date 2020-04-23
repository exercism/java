import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Ignore;

public class TriangleTest {

    @Test
    public void equilateralTrianglesHaveEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(2, 2, 2);

        assertTrue(triangle.isEquilateral());
    }

    @Ignore("Remove to run test")
    @Test
    public void trianglesWithOneUnequalSideAreNotEquilateral() throws TriangleException {
        Triangle triangle = new Triangle(2, 3, 2);

        assertFalse(triangle.isEquilateral());
    }

    @Ignore("Remove to run test")
    @Test
    public void trianglesWithNoEqualSidesAreNotEquilateral() throws TriangleException {
        Triangle triangle = new Triangle(5, 4, 6);

        assertFalse(triangle.isEquilateral());
    }

    @Ignore("Remove to run test")
    @Test
    public void trianglesWithNoSizeAreIllegal() {
        assertThrows(
            TriangleException.class,
            () -> new Triangle(0, 0, 0));
    }

    @Ignore("Remove to run test")
    @Test
    public void verySmallTrianglesCanBeEquilateral() throws TriangleException {
        Triangle triangle = new Triangle(0.5, 0.5, 0.5);

        assertTrue(triangle.isEquilateral());
    }

    @Ignore("Remove to run test")
    @Test
    public void isoscelesTrianglesHaveLastTwoSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(3, 4, 4);

        assertTrue(triangle.isIsosceles());
    }

    @Ignore("Remove to run test")
    @Test
    public void isoscelesTrianglesHaveTwoFirstSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 3);

        assertTrue(triangle.isIsosceles());
    }

    @Ignore("Remove to run test")
    @Test
    public void isoscelesTrianglesHaveFirstAndLastSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(4, 3, 4);

        assertTrue(triangle.isIsosceles());
    }

    @Ignore("Remove to run test")
    @Test
    public void equilateralTrianglesAreAlsoIsosceles() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 4);

        assertTrue(triangle.isIsosceles());
    }

    @Ignore("Remove to run test")
    @Test
    public void noSidesAreEqualCantBeIsoceles() throws TriangleException {
        Triangle triangle = new Triangle(2, 3, 4);

        assertFalse(triangle.isIsosceles());
    }

    @Ignore("Remove to run test")
    @Test
    public void firstTriangleInequalityViolation() {
        assertThrows(
            TriangleException.class,
            () -> new Triangle(1, 1, 3));
    }
    
    @Ignore("Remove to run test")
    @Test
    public void secondTriangleInequalityViolation() {
        assertThrows(
            TriangleException.class,
            () -> new Triangle(1, 3, 1));
    }
    
    @Ignore("Remove to run test")
    @Test
    public void thirdTriangleInequalityViolation() {
        assertThrows(
            TriangleException.class,
            () -> new Triangle(3, 1, 1));
    }

    @Ignore("Remove to run test")
    @Test
    public void verySmallTrianglesCanBeIsosceles() throws TriangleException {
        Triangle triangle = new Triangle(0.5, 0.4, 0.5);

        assertTrue(triangle.isIsosceles());
    }

    @Ignore("Remove to run test")
    @Test
    public void scaleneTrianglesHaveNoEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(5, 4, 6);

        assertTrue(triangle.isScalene());
    }

    @Ignore("Remove to run test")
    @Test
    public void allSidesEqualAreNotScalene() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 4);

        assertFalse(triangle.isScalene());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoSidesEqualAreNotScalene() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 3);

        assertFalse(triangle.isScalene());
    }

    @Ignore("Remove to run test")
    @Test
    public void mayNotViolateTriangleInequality() {
        assertThrows(
            TriangleException.class,
            () -> new Triangle(7, 3, 2));
    }

    @Ignore("Remove to run test")
    @Test
    public void verySmallTrianglesCanBeScalene() throws TriangleException {
        Triangle triangle = new Triangle(0.5, 0.4, 0.6);

        assertTrue(triangle.isScalene());
    }
}
