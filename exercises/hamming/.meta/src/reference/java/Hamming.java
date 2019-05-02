import java.util.function.IntPredicate;
import java.util.stream.IntStream;

class Hamming {
    private final int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        String exceptionMessage = "leftStrand and rightStrand must be of equal length.";
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.isEmpty()) {
                exceptionMessage = "left strand must not be empty.";
            }
            if (rightStrand.isEmpty()) {
                exceptionMessage = "right strand must not be empty.";
            }
            throw new IllegalArgumentException(exceptionMessage);
        }

        IntPredicate areNotEqual = index -> leftStrand.charAt(index) != rightStrand.charAt(index);
        hammingDistance = (int) IntStream.range(0, leftStrand.length()).filter(areNotEqual).count();
    }

    int getHammingDistance() {
        return hammingDistance;
    }
}
