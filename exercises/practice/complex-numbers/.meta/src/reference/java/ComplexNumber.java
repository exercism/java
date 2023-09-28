final class ComplexNumber {

    private final double real;

    private final double imaginary;

    ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    double getReal() {
        return real;
    }

    double getImaginary() {
        return imaginary;
    }

    ComplexNumber multiply(ComplexNumber other) {
        return new ComplexNumber(
                real * other.real - imaginary * other.imaginary,
                real * other.imaginary + imaginary * other.real);
    }

    ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }

    ComplexNumber divide(ComplexNumber other) {
        return this.multiply(other.conjugate()).divide(Math.pow(other.abs(), 2));
    }

    double abs() {
        return Math.hypot(real, imaginary);
    }

    ComplexNumber conjugate() {
        return new ComplexNumber(real, -imaginary);
    }

    ComplexNumber exponentialOf() {
        return new ComplexNumber(Math.cos(imaginary), Math.sin(imaginary)).multiply(Math.exp(real));
    }

    private ComplexNumber divide(double factor) {
        return new ComplexNumber(real / factor, imaginary / factor);
    }

    private ComplexNumber multiply(double factor) {
        return new ComplexNumber(factor * real, factor * imaginary);
    }
}
