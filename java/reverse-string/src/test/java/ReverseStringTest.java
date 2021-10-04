import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringTest {

    @Test
    public void testAnEmptyString() {
        assertEquals("", new ReverseString().reverse(""));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAWord() {
        assertEquals("tobor", new ReverseString().reverse("robot"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testACapitalizedWord() {
        assertEquals("nemaR", new ReverseString().reverse("Ramen"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testASentenceWithPunctuation() {
        assertEquals("!yrgnuh m'I", new ReverseString().reverse("I'm hungry!"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAPalindrome() {
        assertEquals("racecar", new ReverseString().reverse("racecar"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAnEvenSizedWord() {
        assertEquals("reward", new ReverseString().reverse("drawer"));
    }
}
