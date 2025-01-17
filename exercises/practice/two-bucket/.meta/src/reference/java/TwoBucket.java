import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class TwoBucket {
    
    private int totalMoves = Integer.MAX_VALUE;
    private String finalBucket = "";
    private int otherBucket = Integer.MAX_VALUE;

    private final List<Map.Entry<Integer, Integer>> statesReached = new ArrayList<>();

    TwoBucket(int bucketOneCap, int bucketTwoCap, int desiredLiters, String startBucket) {
        checkIfImpossible(desiredLiters, bucketOneCap, bucketTwoCap);

        fillBuckets(
            startBucket.equals("one") ? bucketOneCap : 0,
            bucketOneCap,
            startBucket.equals("two") ? bucketTwoCap : 0,
            bucketTwoCap,
            desiredLiters,
            1,
            startBucket
        );
    }

    private void fillBuckets(
        int bucketOne,
        int bucketOneCap,
        int bucketTwo,
        int bucketTwoCap,
        int desiredLiters,
        int actionsTaken,
        String startingBucket
    ) {
        if (startingBucket.equals("one") && bucketOne == 0 && bucketTwo == bucketTwoCap
            || startingBucket.equals("two") && bucketTwo == 0 && bucketOne == bucketOneCap
            || statesReached.contains(Map.entry(bucketOne, bucketTwo))
            || bucketOne > bucketOneCap
            || bucketTwo > bucketTwoCap) {
            return;
        }
        
        if (bucketOne == desiredLiters) {
            if (actionsTaken < totalMoves) {
                this.totalMoves = actionsTaken;
                this.finalBucket = "one";
                this.otherBucket = bucketTwo;
            }
            return;
        }
        if (bucketTwo == desiredLiters) {
            if (actionsTaken < totalMoves) {
                this.totalMoves = actionsTaken;
                this.finalBucket = "two";
                this.otherBucket = bucketOne;
            }
            return;
        }

        statesReached.add(Map.entry(bucketOne, bucketTwo));

        if (bucketOne != 0) {
            fillBuckets(0, bucketOneCap, bucketTwo, bucketTwoCap, desiredLiters, actionsTaken + 1, startingBucket);
        }
        if (bucketTwo != 0) {
            fillBuckets(bucketOne, bucketOneCap, 0, bucketTwoCap, desiredLiters, actionsTaken + 1, startingBucket);
        }

        fillBuckets(
            bucketOneCap, bucketOneCap, bucketTwo, bucketTwoCap, desiredLiters, 
            actionsTaken + 1, startingBucket
        );
        fillBuckets(
            bucketOne, bucketOneCap, bucketTwoCap, bucketTwoCap, desiredLiters, 
            actionsTaken + 1, startingBucket
        );

        if (bucketOne + bucketTwo <= bucketTwoCap) {
            fillBuckets(
                0, bucketOneCap, bucketTwo + bucketOne, bucketTwoCap, desiredLiters, 
                actionsTaken + 1, startingBucket
            );
        } else {
            fillBuckets(
                bucketOne + bucketTwo - bucketTwoCap, bucketOneCap, bucketTwoCap, bucketTwoCap, 
                desiredLiters, actionsTaken + 1, startingBucket
            );
        }
        if (bucketOne + bucketTwo <= bucketOneCap) {
            fillBuckets(
                bucketOne + bucketTwo, bucketOneCap, 0, bucketTwoCap, desiredLiters, 
                actionsTaken + 1, startingBucket
            );
        } else {
            fillBuckets(
                bucketOneCap, bucketOneCap, bucketTwo + bucketOne - bucketOneCap, bucketTwoCap, 
                desiredLiters, actionsTaken + 1, startingBucket
            );
        }
    }

    private void checkIfImpossible(int desiredLiters, int bucketOneCap, int bucketTwoCap) {
        boolean exceedsCapacity = desiredLiters > bucketOneCap && desiredLiters > bucketTwoCap;
        boolean invalidDivision = desiredLiters % gcd(bucketOneCap, bucketTwoCap) != 0;
        
        if (exceedsCapacity || invalidDivision) {
            throw new UnreachableGoalException();
        }
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    Result getResult() {
        return new Result(totalMoves, finalBucket, otherBucket);
    }
}
