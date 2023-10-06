import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseStringTest {

    @Test
    public void testAnEmptyString() {
        assertThat(new ReverseString().reverse("")).isEqualTo("");
    }

    @Ignore("Remove to run test")
    @Test
    public void testAWord() {
        assertThat(new ReverseString().reverse("robot")).isEqualTo("tobor");
    }

    @Ignore("Remove to run test")
    @Test
    public void testACapitalizedWord() {
        assertThat(new ReverseString().reverse("Ramen")).isEqualTo("nemaR");
    }

    @Ignore("Remove to run test")
    @Test
    public void testASentenceWithPunctuation() {
        assertThat(new ReverseString().reverse("I'm hungry!")).isEqualTo("!yrgnuh m'I");
    }

    @Ignore("Remove to run test")
    @Test
    public void testAPalindrome() {
        assertThat(new ReverseString().reverse("racecar")).isEqualTo("racecar");
    }

    @Ignore("Remove to run test")
    @Test
    public void testAnEvenSizedWord() {
        assertThat(new ReverseString().reverse("drawer")).isEqualTo("reward");
    }
}
