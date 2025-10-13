import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

public class TriangleTest {

    @Test
    @DisplayName("equilateral triangle")
    public void equilateralTrianglesHaveEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(2, 2, 2);

        assertThat(triangle.isEquilateral()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("any side is unequal")
    public void trianglesWithOneUnequalSideAreNotEquilateral() throws TriangleException {
        Triangle triangle = new Triangle(2, 3, 2);

        assertThat(triangle.isEquilateral()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no sides are equal")
    public void trianglesWithNoEqualSidesAreNotEquilateral() throws TriangleException {
        Triangle triangle = new Triangle(5, 4, 6);

        assertThat(triangle.isEquilateral()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("all zero sides is not a triangle")
    public void trianglesWithNoSizeAreIllegal() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(0, 0, 0));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sides may be floats")
    public void verySmallTrianglesCanBeEquilateral() throws TriangleException {
        Triangle triangle = new Triangle(0.5, 0.5, 0.5);

        assertThat(triangle.isEquilateral()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("last two sides are equal")
    public void isoscelesTrianglesHaveLastTwoSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(3, 4, 4);

        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("first two sides are equal")
    public void isoscelesTrianglesHaveTwoFirstSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 3);

        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("first and last sides are equal")
    public void isoscelesTrianglesHaveFirstAndLastSidesEqual() throws TriangleException {
        Triangle triangle = new Triangle(4, 3, 4);

        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("equilateral triangles are also isosceles")
    public void equilateralTrianglesAreAlsoIsosceles() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 4);

        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no sides are equal")
    public void noSidesAreEqualCantBeIsoceles() throws TriangleException {
        Triangle triangle = new Triangle(2, 3, 4);

        assertThat(triangle.isIsosceles()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("first triangle inequality violation")
    public void firstTriangleInequalityViolation() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(1, 1, 3));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("second triangle inequality violation")
    public void secondTriangleInequalityViolation() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(1, 3, 1));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("third triangle inequality violation")
    public void thirdTriangleInequalityViolation() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(3, 1, 1));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sides may be floats")
    public void verySmallTrianglesCanBeIsosceles() throws TriangleException {
        Triangle triangle = new Triangle(0.5, 0.4, 0.5);

        assertThat(triangle.isIsosceles()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("")
    public void scaleneTrianglesHaveNoEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(5, 4, 6);

        assertThat(triangle.isScalene()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no sides are equal")
    public void allSidesEqualAreNotScalene() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 4);

        assertThat(triangle.isScalene()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("first and second sides are equal")
    public void twoSidesEqualAreNotScalene() throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 3);

        assertThat(triangle.isScalene()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("first and third sides are equal")
    public void firstAndThirdSidesAreEqualAreNotScalene() throws TriangleException {
        Triangle triangle = new Triangle(3, 4, 3);

        assertThat(triangle.isScalene()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("second and third sides are equal")
    public void secondAndThirdSidesAreEqualAreNotScalene() throws TriangleException {
        Triangle triangle = new Triangle(4, 3, 3);

        assertThat(triangle.isScalene()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("may not violate triangle inequality")
    public void mayNotViolateTriangleInequality() {
        assertThatExceptionOfType(TriangleException.class).isThrownBy(() -> new Triangle(7, 3, 2));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sides may be floats")
    public void verySmallTrianglesCanBeScalene() throws TriangleException {
        Triangle triangle = new Triangle(0.5, 0.4, 0.6);

        assertThat(triangle.isScalene()).isTrue();
    }
}
