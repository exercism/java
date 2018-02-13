import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TwoBucketTest {
	
	@Test
	public void testBucketOneSizeThreeBucketTwoSizeFiveStartWithOne() {
		
		TwoBucket twoBucket = new TwoBucket(3, 5, 1, "one");
		
		assertEquals(twoBucket.getTotalMoves(), 4);
		assertEquals(twoBucket.getFinalBucket(), "one");
		assertEquals(twoBucket.getOtherBucket(), 5);
		
	}
	
	@Ignore("Remove to run test")
	@Test
	public void testBucketOneSizeThreeBucketTwoSizeFiveStartWithTwo() {
		
		TwoBucket twoBucket = new TwoBucket(3, 5, 1, "two");
		
		assertEquals(twoBucket.getTotalMoves(), 8);
		assertEquals(twoBucket.getFinalBucket(), "two");
		assertEquals(twoBucket.getOtherBucket(), 3);
		
	}
	
	@Ignore("Remove to run test")
	@Test
	public void testBucketOneSizeSevenBucketTwoSizeElevenStartWithOne() {
		
		TwoBucket twoBucket = new TwoBucket(7, 11, 2, "one");
		
		assertEquals(twoBucket.getTotalMoves(), 14);
		assertEquals(twoBucket.getFinalBucket(), "one");
		assertEquals(twoBucket.getOtherBucket(), 11);
		
	}
	
	@Ignore("Remove to run test")
	@Test
	public void testBucketOneSizeSevenBucketTwoSizeElevenStartWithTwo() {
		
		TwoBucket twoBucket = new TwoBucket(7, 11, 2, "two");
		
		assertEquals(twoBucket.getTotalMoves(), 18);
		assertEquals(twoBucket.getFinalBucket(), "two");
		assertEquals(twoBucket.getOtherBucket(), 7);
		
	}
	
	@Ignore("Remove to run test")
	@Test
	public void testBucketOneSizeOneBucketTwoSizeThreeStartWithTwo() {
		
		TwoBucket twoBucket = new TwoBucket(1, 3, 3, "two");
		
		assertEquals(twoBucket.getTotalMoves(), 1);
		assertEquals(twoBucket.getFinalBucket(), "two");
		assertEquals(twoBucket.getOtherBucket(), 0);
		
	}
	
	@Ignore("Remove to run test")
	@Test
	public void testBucketOneSizeTwoBucketTwoSizeThreeStartWithOne() {
		
		TwoBucket twoBucket = new TwoBucket(2, 3, 3, "one");
		
		assertEquals(twoBucket.getTotalMoves(), 2);
		assertEquals(twoBucket.getFinalBucket(), "two");
		assertEquals(twoBucket.getOtherBucket(), 2);
		
	}
}
