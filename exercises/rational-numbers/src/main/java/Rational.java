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
}
