public class Hamming {

    private String leftStrand;
    private String rightStrand;

    public Hamming(String leftStrand, String rightStrand) {

        int rightSize = rightStrand.length();
        int leftSize = leftStrand.length();

        if (leftSize == 0 && rightSize != 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (leftSize != 0 && rightSize == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftSize != rightSize) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    public int getHammingDistance() {
        int distance = 0;
        int size = leftStrand.length();

        for (int i = 0; i < size; i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }
}
