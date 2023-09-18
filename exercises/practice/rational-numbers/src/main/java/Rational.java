import java.util.Objects;

class Rational {

    Rational(int numerator, int denominator) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int getNumerator() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int getDenominator() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Rational add(Rational other) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Rational subtract(Rational other) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Rational multiply(Rational other) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Rational divide(Rational other) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Rational abs() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Rational pow(int power) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    double exp(double exponent) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.getNumerator(), this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rational other) {
            return this.getNumerator() == other.getNumerator()
                    && this.getDenominator() == other.getDenominator();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getNumerator(), this.getDenominator());
    }
}
