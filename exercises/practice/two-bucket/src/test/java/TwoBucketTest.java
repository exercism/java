import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TwoBucketTest {

    @Test
    @DisplayName("Measure using bucket one of size 3 and bucket two of size 5 - start with bucket one")
    public void testBucketOneSizeThreeBucketTwoSizeFiveStartWithOne() {

        Result bucketResult = new TwoBucket(3, 5, 1, "one").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(4);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("one");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(5);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Measure using bucket one of size 3 and bucket two of size 5 - start with bucket two")
    public void testBucketOneSizeThreeBucketTwoSizeFiveStartWithTwo() {

        Result bucketResult = new TwoBucket(3, 5, 1, "two").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(8);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("two");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(3);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Measure using bucket one of size 7 and bucket two of size 11 - start with bucket one")
    public void testBucketOneSizeSevenBucketTwoSizeElevenStartWithOne() {

        Result bucketResult = new TwoBucket(7, 11, 2, "one").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(14);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("one");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(11);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Measure using bucket one of size 7 and bucket two of size 11 - start with bucket two")
    public void testBucketOneSizeSevenBucketTwoSizeElevenStartWithTwo() {

        Result bucketResult = new TwoBucket(7, 11, 2, "two").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(18);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("two");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(7);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Measure one step using bucket one of size 1 and bucket two of size 3 - start with bucket two")
    public void testBucketOneSizeOneBucketTwoSizeThreeStartWithTwo() {

        Result bucketResult = new TwoBucket(1, 3, 3, "two").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(1);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("two");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(0);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName(
            "Measure using bucket one of size 2 and bucket two of size 3 - " +
                    "start with bucket one and end with bucket two")
    public void testBucketOneSizeTwoBucketTwoSizeThreeStartWithOne() {

        Result bucketResult = new TwoBucket(2, 3, 3, "one").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(2);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("two");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(2);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Measure using bucket one much bigger than bucket two")
    public void testBucketOneMuchBiggerThanBucketTwo() {

        Result bucketResult = new TwoBucket(5, 1, 2, "one").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(6);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("one");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(1);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Measure using bucket one much smaller than bucket two")
    public void testBucketOneMuchSmallerThanBucketTwo() {

        Result bucketResult = new TwoBucket(3, 15, 9, "one").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(6);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("two");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(0);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Not possible to reach the goal")
    public void testReachingGoalIsImpossible() {

        assertThatExceptionOfType(UnreachableGoalException.class)
                .isThrownBy(() -> new TwoBucket(6, 15, 5, "one").getResult());

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("With the same buckets but a different goal, then it is possible")
    public void testBucketOneSizeSixBucketTwoSizeFifteenStartWithOne() {

        Result bucketResult = new TwoBucket(6, 15, 9, "one").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(10);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("two");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(0);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Goal larger than both buckets is impossible")
    public void testGoalLargerThanBothBucketsIsImpossible() {

        assertThatExceptionOfType(UnreachableGoalException.class)
                .isThrownBy(() -> new TwoBucket(5, 7, 8, "one").getResult());

    }
}
