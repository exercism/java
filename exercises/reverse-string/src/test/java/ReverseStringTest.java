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

    // Bonus: This is not required to complete the exercise
    // This requires splitting on unicode code points instead of char code points
    @Ignore("Remove to run test")
    @Test
    public void testEmoji() {
        assertEquals("👍☕", new ReverseString().reverse("☕👍"));
    }
}
