final class ComplexNumber {

    private final double real;

    private final double imag;

    ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    double getReal() {
        return real;
    }

    double getImag() {
        return imag;
    }

    ComplexNumber times(ComplexNumber other) {
        return new ComplexNumber(
                real * other.real - imag * other.imag,
                real * other.imag + imag * other.real);
    }

    ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imag + other.imag);
    }

    ComplexNumber minus(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imag - other.imag);
    }

    ComplexNumber div(ComplexNumber other) {
        return this.times(other.conjugate()).div(Math.pow(other.abs(), 2));
    }

    double abs() {
        return Math.hypot(real, imag);
    }

    ComplexNumber conjugate() {
        return new ComplexNumber(real, -imag);
    }

    ComplexNumber exponentialOf() {
        return new ComplexNumber(Math.cos(imag), Math.sin(imag)).times(Math.exp(real));
    }

    private ComplexNumber div(double factor) {
        return new ComplexNumber(real / factor, imag / factor);
    }

    private ComplexNumber times(double factor) {
        return new ComplexNumber(factor * real, factor * imag);
    }
}
