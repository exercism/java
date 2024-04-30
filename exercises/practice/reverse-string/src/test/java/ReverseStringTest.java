import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseStringTest {

    @Test
    public void testAnEmptyString() {
        assertThat(new ReverseString().reverse("")).isEqualTo("");
    }

    @Disabled("Remove to run test")
    @Test
    public void testAWord() {
        assertThat(new ReverseString().reverse("robot")).isEqualTo("tobor");
    }

    @Disabled("Remove to run test")
    @Test
    public void testACapitalizedWord() {
        assertThat(new ReverseString().reverse("Ramen")).isEqualTo("nemaR");
    }

    @Disabled("Remove to run test")
    @Test
    public void testASentenceWithPunctuation() {
        assertThat(new ReverseString().reverse("I'm hungry!")).isEqualTo("!yrgnuh m'I");
    }

    @Disabled("Remove to run test")
    @Test
    public void testAPalindrome() {
        assertThat(new ReverseString().reverse("racecar")).isEqualTo("racecar");
    }

    @Disabled("Remove to run test")
    @Test
    public void testAnEvenSizedWord() {
        assertThat(new ReverseString().reverse("drawer")).isEqualTo("reward");
    }
}
