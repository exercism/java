import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class SayTest {

    private Say say = new Say();
    
    @Test
    public void zero() {
        assertEquals("zero", say.say(0));
    }
    
    @Ignore("Remove to run test")
    @Test
    public void one() {
        assertEquals("one", say.say(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void fourteen() {
        assertEquals("fourteen", say.say(14));
    }

    @Ignore("Remove to run test")
    @Test
    public void twenty() {
        assertEquals("twenty", say.say(20));
    }

    @Ignore("Remove to run test")
    @Test
    public void twentyTwo() {
        assertEquals("twenty-two", say.say(22));
    }

    @Ignore("Remove to run test")
    @Test
    public void oneHundred() {
        assertEquals("one hundred", say.say(100));
    }

    @Ignore("Remove to run test")
    @Test
    public void oneHundredTwentyThree() {
        assertEquals("one hundred twenty-three", say.say(123));
    }

    @Ignore("Remove to run test")
    @Test
    public void oneThousand() {
        assertEquals("one thousand", say.say(1_000));
    }

    @Ignore("Remove to run test")
    @Test
    public void oneThousandTwoHundredThirtyFour() {
        assertEquals("one thousand two hundred thirty-four", say.say(1_234));
    }

    @Ignore("Remove to run test")
    @Test
    public void oneMillion() {
        assertEquals("one million", say.say(1_000_000));
    }
    
    @Ignore("Remove to run test")
    @Test
    public void oneMillionTwoThousandThreeHundredFortyFive() {
        assertEquals("one million two thousand three hundred forty-five", say.say(1_002_345));
    }
    
    @Ignore("Remove to run test")
    @Test
    public void oneBillion() {
        assertEquals("one billion", say.say(1_000_000_000));
    }
    
    @Ignore("Remove to run test")
    @Test
    public void nineHundredEightySevenBillionSixHundredFiftyFourThreeHundredTwentyOneThousandOneHundredTwentyThree() {
        assertEquals("nine hundred eighty-seven billion six hundred fifty-four million" +
                     " three hundred twenty-one thousand one hundred twenty-three", say.say(987_654_321_123L));
    }
    
    @Ignore("Remove to run test")
    @Test(expected = IllegalArgumentException.class)
    public void illegalNegativeNumber() {
        say.say(-1);
    }

    @Ignore("Remove to run test")
    @Test(expected = IllegalArgumentException.class)
    public void illegalTooBigNumber() {
        say.say(1_000_000_000_000L);
    }    
}
