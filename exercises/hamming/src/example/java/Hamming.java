public class Hamming {
    private final int hammingDistance;

    public Hamming(String leftStrand, String rightStrand) {
        hammingDistance = computeHammingDistance(leftStrand, rightStrand);
    }

    public int getHammingDistance() {
        return hammingDistance;
    }

    private int computeHammingDistance(String leftStrand, String rightStrand) {
        if(leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        final int length = Math.min(leftStrand.length(), rightStrand.length());
        int distance = 0;
        for (int i = 0; i < length; i++) {
          distance += hammingContributionAt(i, leftStrand, rightStrand);
        }

        return distance;
    }

    private int hammingContributionAt(int index, String leftStrand, String rightStrand) {
      return leftStrand.charAt(index) != rightStrand.charAt(index) ? 1 : 0;
    }

}
