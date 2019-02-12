class Hamming {
    private int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        hammingDistance = computeHammingDistance(leftStrand, rightStrand);
    }

    int getHammingDistance() {
        return hammingDistance;
    }

    private int computeHammingDistance(String leftStrand, String rightStrand) {
        if (leftStrand.length() == 0 && rightStrand.length() == 0) {
            return 0;
        } else if (leftStrand.length() == 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.length() == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        int length = leftStrand.length();
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
