import org.junit.Test;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.*;

public class SayTest {

    private Say say = new Say();
    
    @Test
    public void zero() {
        assertThat(say.say(0)).isEqualTo("zero");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void one() {
        assertThat(say.say(1)).isEqualTo("one");
    }

    @Ignore("Remove to run test")
    @Test
    public void fourteen() {
        assertThat(say.say(14)).isEqualTo("fourteen");
    }

    @Ignore("Remove to run test")
    @Test
    public void twenty() {
        assertThat(say.say(20)).isEqualTo("twenty");
    }

    @Ignore("Remove to run test")
    @Test
    public void twentyTwo() {
        assertThat(say.say(22)).isEqualTo("twenty-two");
    }

    @Ignore("Remove to run test")
    @Test
    public void oneHundred() {
        assertThat(say.say(100)).isEqualTo("one hundred");
    }

    @Ignore("Remove to run test")
    @Test
    public void oneHundredTwentyThree() {
        assertThat(say.say(123)).isEqualTo("one hundred twenty-three");
    }

    @Ignore("Remove to run test")
    @Test
    public void oneThousand() {
        assertThat(say.say(1_000)).isEqualTo("one thousand");
    }

    @Ignore("Remove to run test")
    @Test
    public void oneThousandTwoHundredThirtyFour() {
        assertThat(say.say(1_234)).isEqualTo("one thousand two hundred thirty-four");
    }

    @Ignore("Remove to run test")
    @Test
    public void oneMillion() {
        assertThat(say.say(1_000_000)).isEqualTo("one million");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void oneMillionTwoThousandThreeHundredFortyFive() {
        assertThat(say.say(1_002_345)).isEqualTo("one million two thousand three hundred forty-five");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void oneBillion() {
        assertThat(say.say(1_000_000_000)).isEqualTo("one billion");
    }
    
    @Ignore("Remove to run test")
    @Test
    public void nineHundredEightySevenBillionSixHundredFiftyFourThreeHundredTwentyOneThousandOneHundredTwentyThree() {
        assertThat(say.say(987_654_321_123L))
            .isEqualTo("nine hundred eighty-seven billion six hundred fifty-four million" + 
                       " three hundred twenty-one thousand one hundred twenty-three");
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
