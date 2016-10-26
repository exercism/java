import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeapTest {

  @Test
  public void leapYearIsNotCommon() {
    Leap leapYear = new Leap(2015);
    assertFalse(leapYear.isLeap());
  }

  @Test
  @Ignore
  public void everyFourYears() {
    Leap leapYear = new Leap(2016);
    assertTrue(leapYear.isLeap());
  }

  @Test
  @Ignore
  public void skipEvery100Years() {
    Leap leapYear = new Leap(1900);
    assertFalse(leapYear.isLeap());
  }

  @Test
  @Ignore
  public void reintroduceEvery400Years() {
    Leap leapYear = new Leap(2000);
    assertTrue(leapYear.isLeap());
  }

  // Feel free to enable the following tests to check some more examples

  @Test
  @Ignore
  public void leapYearIsNotCommon2() {
    Leap leapYear = new Leap(1978);
    assertFalse(leapYear.isLeap());
  }

  @Test
  @Ignore
  public void everyFourYears2() {
    Leap leapYear = new Leap(1992);
    assertTrue(leapYear.isLeap());
  }

  @Test
  @Ignore
  public void skipEvery100Years2() {
    Leap leapYear = new Leap(2100);
    assertFalse(leapYear.isLeap());
  }

  @Test
  @Ignore
  public void reintroduceEvery400Years2() {
    Leap leapYear = new Leap(2400);
    assertTrue(leapYear.isLeap());
  }
}
