import java.util.stream.IntStream;

final class NaturalNumber {

    private final int naturalNumber;

    NaturalNumber(int naturalNumber) {
        if (naturalNumber <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.naturalNumber = naturalNumber;
    }

    Classification getClassification() {
        final int aliquotSum = computeAliquotSum();

        if (aliquotSum == naturalNumber) {
            return Classification.PERFECT;
        } else if (aliquotSum > naturalNumber) {
            return Classification.ABUNDANT;
        } else {
            return Classification.DEFICIENT;
        }
    }

    private int computeAliquotSum() {
        return IntStream.range(1, naturalNumber)
                .filter(it -> naturalNumber % it == 0)
                .sum();
    }

}
