import java.util.function.IntPredicate;
import java.util.stream.IntStream;

class Hamming {
    private final int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException(("strands must be of equal length"));
        }

        IntPredicate areNotEqual = index -> leftStrand.charAt(index) != rightStrand.charAt(index);
        hammingDistance = (int) IntStream.range(0, leftStrand.length()).filter(areNotEqual).count();
    }

    int getHammingDistance() {
        return hammingDistance;
    }
}
