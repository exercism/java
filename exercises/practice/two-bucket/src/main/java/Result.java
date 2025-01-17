final class Result {

    private final int totalMoves;
    private final String finalBucket;
    private final int otherBucket;

    Result(int totalMoves, String finalBuckets, int otherBucket) {
        this.totalMoves = totalMoves;
        this.finalBucket = finalBuckets;
        this.otherBucket = otherBucket;
    }

    public int getTotalMoves() {
        return totalMoves;
    }

    public String getFinalBucket() {
        return finalBucket;
    }

    public int getOtherBucket() {
        return otherBucket;
    }
}
