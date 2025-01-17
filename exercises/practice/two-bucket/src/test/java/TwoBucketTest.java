import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TwoBucketTest {

    @Test
    public void testBucketOneSizeThreeBucketTwoSizeFiveStartWithOne() {

        Result bucketResult = new TwoBucket(3, 5, 1, "one").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(4);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("one");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(5);

    }

    @Disabled("Remove to run test")
    @Test
    public void testBucketOneSizeThreeBucketTwoSizeFiveStartWithTwo() {

        Result bucketResult = new TwoBucket(3, 5, 1, "two").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(8);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("two");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(3);

    }

    @Disabled("Remove to run test")
    @Test
    public void testBucketOneSizeSevenBucketTwoSizeElevenStartWithOne() {

        Result bucketResult = new TwoBucket(7, 11, 2, "one").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(14);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("one");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(11);

    }

    @Disabled("Remove to run test")
    @Test
    public void testBucketOneSizeSevenBucketTwoSizeElevenStartWithTwo() {

        Result bucketResult = new TwoBucket(7, 11, 2, "two").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(18);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("two");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(7);

    }

    @Disabled("Remove to run test")
    @Test
    public void testBucketOneSizeOneBucketTwoSizeThreeStartWithTwo() {

        Result bucketResult = new TwoBucket(1, 3, 3, "two").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(1);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("two");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(0);

    }

    @Disabled("Remove to run test")
    @Test
    public void testBucketOneSizeTwoBucketTwoSizeThreeStartWithOne() {

        Result bucketResult = new TwoBucket(2, 3, 3, "one").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(2);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("two");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(2);

    }

    @Disabled("Remove to run test")
    @Test
    public void testReachingGoalIsImpossible() {
        
        assertThatExceptionOfType(UnreachableGoalException.class)
                .isThrownBy(() -> new TwoBucket(6, 15, 5, "one").getResult());

    }

    @Disabled("Remove to run test")
    @Test
    public void testBucketOneSizeSixBucketTwoSizeFifteenStartWithOne() {

        Result bucketResult = new TwoBucket(6, 15, 9, "one").getResult();

        assertThat(bucketResult.getTotalMoves()).isEqualTo(10);
        assertThat(bucketResult.getFinalBucket()).isEqualTo("two");
        assertThat(bucketResult.getOtherBucket()).isEqualTo(0);

    }   

    @Disabled("Remove to run test")
    @Test
    public void testGoalLargerThanBothBucketsIsImpossible() {

        assertThatExceptionOfType(UnreachableGoalException.class)
                .isThrownBy(() -> new TwoBucket(5, 7, 8, "one").getResult());

    }
}
