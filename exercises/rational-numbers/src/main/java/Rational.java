public class Rational {
    private int numerator;
    private int denominator;

    public Rational(final int numerator, final int denominator) throws IllegalArgumentException {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator must not be zero.");
        }

        this.numerator = numerator;
        this.denominator = denominator;

        this.reduce();
        this.ensureSignInNumerator();
    }

    private void reduce() {
        final int commonDivisor = gcd(this.numerator, this.denominator);

        this.numerator /= commonDivisor;
        this.denominator /= commonDivisor;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            final int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private void ensureSignInNumerator() {
        if (this.denominator < 0) {
            this.denominator = -this.denominator;
            this.numerator = -this.numerator;
        }
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public Rational abs() {
        return new Rational(abs(this.numerator), abs(this.denominator));
    }

    private int abs(int x) {
        final int mask = x >> 31;
        return (mask ^ x) - mask;
    }

    public Rational add(Rational that) {
        final int commonDenominator = this.denominator * that.denominator;

        return new Rational(
                this.numerator * that.denominator + that.numerator * this.denominator,
                commonDenominator);
    }

    public Rational subtract(Rational that) {
        final int commonDenominator = this.denominator * that.denominator;

        return new Rational(
                this.numerator * that.denominator - that.numerator * this.denominator,
                commonDenominator);
    }

    public Rational multiply(Rational that) {
        return new Rational(this.numerator * that.numerator, this.denominator * that.denominator);
    }

    public Rational divide(Rational that) {
        return new Rational(this.numerator * that.denominator, this.denominator * that.numerator);
    }

    public Rational pow(int n) {
        return new Rational(pow(this.numerator, n), pow(this.denominator, n));
    }

    public double pow(double x) {
        return Math.pow(this.numerator, x) / Math.pow(this.denominator, x);
    }

    private int pow(final int base, final int exponent) {
        int product = 1;

        for (int i = 0; i < exponent; i++) {
            product *= base;
        }

        return product;
    }

    public double exp(double base) {
        return Math.pow(Math.pow(base, this.numerator), 1.0 / this.denominator);
    }
}
