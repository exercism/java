import org.junit.Test;
import org.junit.Assert;
import org.junit.Ignore;

public class LeapTest {

    @Test
    public void Valid_leap_year()
    {
        Assert.assertTrue(Leap.IsLeap(1996));
    }

    @Test
    @Ignore
    public void Invalid_leap_year()
    {
        Assert.assertFalse(Leap.IsLeap(1997));
    }

    @Test
    @Ignore
    public void Turn_of_the_20th_century_is_not_a_leap_year()
    {
        Assert.assertFalse(Leap.IsLeap(1900));
    }

    @Test
    @Ignore
    public void Turn_of_the_25th_century_is_a_leap_year()
    {
        Assert.assertTrue(Leap.IsLeap(2400));
    }
}
