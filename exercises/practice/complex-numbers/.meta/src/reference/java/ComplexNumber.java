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
        double divisor = Math.pow(other.real, 2) + Math.pow(other.imaginary, 2);
        return new ComplexNumber(
            (real * other.real + imaginary * other.imaginary) / divisor,
            (imaginary * other.real - real * other.imaginary) / divisor);
    }

    double abs() {
        return Math.hypot(real, imaginary);
    }

    ComplexNumber conjugate() {
        return new ComplexNumber(real, -imaginary);
    }

    ComplexNumber exponentialOf() {
        return new ComplexNumber(Math.exp(real) * Math.cos(imaginary), Math.exp(real) * Math.sin(imaginary));
    }
}