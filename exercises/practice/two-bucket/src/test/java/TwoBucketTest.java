import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoBucketTest {

    @Test
    public void testBucketOneSizeThreeBucketTwoSizeFiveStartWithOne() {

        TwoBucket twoBucket = new TwoBucket(3, 5, 1, "one");

        assertThat(twoBucket.getTotalMoves()).isEqualTo(4);
        assertThat(twoBucket.getFinalBucket()).isEqualTo("one");
        assertThat(twoBucket.getOtherBucket()).isEqualTo(5);

    }

    @Disabled("Remove to run test")
    @Test
    public void testBucketOneSizeThreeBucketTwoSizeFiveStartWithTwo() {

        TwoBucket twoBucket = new TwoBucket(3, 5, 1, "two");

        assertThat(twoBucket.getTotalMoves()).isEqualTo(8);
        assertThat(twoBucket.getFinalBucket()).isEqualTo("two");
        assertThat(twoBucket.getOtherBucket()).isEqualTo(3);

    }

    @Disabled("Remove to run test")
    @Test
    public void testBucketOneSizeSevenBucketTwoSizeElevenStartWithOne() {

        TwoBucket twoBucket = new TwoBucket(7, 11, 2, "one");

        assertThat(twoBucket.getTotalMoves()).isEqualTo(14);
        assertThat(twoBucket.getFinalBucket()).isEqualTo("one");
        assertThat(twoBucket.getOtherBucket()).isEqualTo(11);

    }

    @Disabled("Remove to run test")
    @Test
    public void testBucketOneSizeSevenBucketTwoSizeElevenStartWithTwo() {

        TwoBucket twoBucket = new TwoBucket(7, 11, 2, "two");

        assertThat(twoBucket.getTotalMoves()).isEqualTo(18);
        assertThat(twoBucket.getFinalBucket()).isEqualTo("two");
        assertThat(twoBucket.getOtherBucket()).isEqualTo(7);

    }

    @Disabled("Remove to run test")
    @Test
    public void testBucketOneSizeOneBucketTwoSizeThreeStartWithTwo() {

        TwoBucket twoBucket = new TwoBucket(1, 3, 3, "two");

        assertThat(twoBucket.getTotalMoves()).isEqualTo(1);
        assertThat(twoBucket.getFinalBucket()).isEqualTo("two");
        assertThat(twoBucket.getOtherBucket()).isEqualTo(0);

    }

    @Disabled("Remove to run test")
    @Test
    public void testBucketOneSizeTwoBucketTwoSizeThreeStartWithOne() {

        TwoBucket twoBucket = new TwoBucket(2, 3, 3, "one");

        assertThat(twoBucket.getTotalMoves()).isEqualTo(2);
        assertThat(twoBucket.getFinalBucket()).isEqualTo("two");
        assertThat(twoBucket.getOtherBucket()).isEqualTo(2);

    }
}
