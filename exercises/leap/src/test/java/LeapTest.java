import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LeapTest {

    @Test
    public void a_known_leap_year() {
        assertEquals(true, new Leap().is_leap_year(1996));
    }

    @Ignore("Remove to run test")
    @Test
    public void any_old_year() {
        assertEquals(false, new Leap().is_leap_year(1997));
    }

    @Ignore("Remove to run test")
    @Test
    public void turn_of_the_20th_century() {
        assertEquals(false, new Leap().is_leap_year(1900));
    }

    @Ignore("Remove to run test")
    @Test
    public void turn_of_the_21st_century() {
        assertEquals(true,new Leap().is_leap_year(2000));
    }

    @Ignore("Remove to run test")
    @Test
    public void turn_of_the_25th_century() {
        assertEquals(true,new Leap().is_leap_year(2400));    

	}

}




