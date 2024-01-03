class Rational {
    private int numerator;
    private int denominator;

    Rational(final int numerator, final int denominator) {
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

    int getNumerator() {
        return this.numerator;
    }

    int getDenominator() {
        return this.denominator;
    }

    Rational abs() {
        return new Rational(abs(this.numerator), abs(this.denominator));
    }

    private int abs(int x) {
        final int mask = x >> 31;
        return (mask ^ x) - mask;
    }

    Rational add(Rational that) {
        final int commonDenominator = this.denominator * that.denominator;

        return new Rational(
                this.numerator * that.denominator + that.numerator * this.denominator,
                commonDenominator);
    }

    Rational subtract(Rational that) {
        final int commonDenominator = this.denominator * that.denominator;

        return new Rational(
                this.numerator * that.denominator - that.numerator * this.denominator,
                commonDenominator);
    }

    Rational multiply(Rational that) {
        return new Rational(this.numerator * that.numerator, this.denominator * that.denominator);
    }

    Rational divide(Rational that) {
        return new Rational(this.numerator * that.denominator, this.denominator * that.numerator);
    }

    Rational pow(int n) {
        if (n < 0) {
            return new Rational(pow(this.denominator, n), pow(this.numerator, n));    
        }
        return new Rational(pow(this.numerator, n), pow(this.denominator, n));
    }

    double pow(double x) {
        return Math.pow(this.numerator, x) / Math.pow(this.denominator, x);
    }

    private int pow(final int base, int exponent) {
        exponent = exponent < 0 ? exponent * -1 : exponent;

        int product = 1;

        for (int i = 0; i < exponent; i++) {
            product *= base;
        }

        return product;
    }

    double exp(double base) {
        return Math.pow(10.0, Math.log10(Math.pow(base, this.numerator)) / this.denominator);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.getNumerator(), this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !this.getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }

        Rational other = (Rational) obj;
        return this.getNumerator() == other.getNumerator()
            && this.getDenominator() == other.getDenominator();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + this.getNumerator();
        result = prime * result + this.getDenominator();

        return result;
    }
}
