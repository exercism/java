import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;
import org.junit.Ignore;

public class TriangleTest {

    @Test
    public void equilateralTrianglesHaveEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(2, 2, 2);

        assertThat(triangle.isEquilateral()).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void trianglesWithOneUnequalSideAreNotEquilateral() throws TriangleException {
        Triangle triangle = new Triangle(2, 3, 2);

        assertThat(triangle.isEquilateral()).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void trianglesWithNoEqualSidesAreNotEquilateral() throws TriangleException {
        Triangle triangle = new Triangle(5, 4, 6);

        assertThat(triangle.isEquilateral()).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void trianglesWithNoSizeAreIllegal() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(0, 0, 0));
    }

    @Ignore("Remove to run test")
    @Test
    public void verySmallTrianglesCanBeEquilateral() throws TriangleException {
        Triangle triangle = new Triangle(0.5, 0.5, 0.5);

        assertThat(triangle.isEquilateral()).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void isoscelesTrianglesHaveLastTwoSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(3, 4, 4);

        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void isoscelesTrianglesHaveTwoFirstSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 3);

        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void isoscelesTrianglesHaveFirstAndLastSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(4, 3, 4);

        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void equilateralTrianglesAreAlsoIsosceles() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 4);

        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void noSidesAreEqualCantBeIsoceles() throws TriangleException {
        Triangle triangle = new Triangle(2, 3, 4);

        assertThat(triangle.isIsosceles()).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void firstTriangleInequalityViolation() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(1, 1, 3));
    }

    @Ignore("Remove to run test")
    @Test
    public void secondTriangleInequalityViolation() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(1, 3, 1));
    }

    @Ignore("Remove to run test")
    @Test
    public void thirdTriangleInequalityViolation() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(3, 1, 1));
    }

    @Ignore("Remove to run test")
    @Test
    public void verySmallTrianglesCanBeIsosceles() throws TriangleException {
        Triangle triangle = new Triangle(0.5, 0.4, 0.5);

        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void scaleneTrianglesHaveNoEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(5, 4, 6);

        assertThat(triangle.isScalene()).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void allSidesEqualAreNotScalene() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 4);

        assertThat(triangle.isScalene()).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void twoSidesEqualAreNotScalene() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 3);

        assertThat(triangle.isScalene()).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void mayNotViolateTriangleInequality() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(7, 3, 2));
    }

    @Ignore("Remove to run test")
    @Test
    public void verySmallTrianglesCanBeScalene() throws TriangleException {
        Triangle triangle = new Triangle(0.5, 0.4, 0.6);

        assertThat(triangle.isScalene()).isTrue();
    }
}
