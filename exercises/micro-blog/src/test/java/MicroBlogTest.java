import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MicroBlogTest {
    
    @Test
    public void englishLanguageShort() {
        String expected = "Hi";
        assertEquals(expected, MicroBlog.truncate("Hi"));
    }

    @Ignore("Remove to run test")
    @Test
    public void englishLanguageLong() {
        String expected = "Hello";
        assertEquals(expected, MicroBlog.truncate("Hello there"));
    }
    
    @Ignore("Remove to run test")
    @Test
    public void germanLanguageShort_broth() {
        String expected = "brühe";
        assertEquals(expected, MicroBlog.truncate("brühe"));
    }

    @Ignore("Remove to run test")
    @Test
    public void germanLanguageLong_bearCarpet_to_beards() {
        String expected = "Bärte";
        assertEquals(expected, MicroBlog.truncate("Bärteppich"));
    }
    
    @Ignore("Remove to run test")
    @Test
    public void bulgarianLanguageShort_good() {
        String expected = "Добър";
        assertEquals(expected, MicroBlog.truncate("Добър"));
    }

    @Ignore("Remove to run test")
    @Test
    public void greekLanguageShort_health() {
        String expected = "υγειά";
        assertEquals(expected, MicroBlog.truncate("υγειά"));
    }
    
    @Ignore("Remove to run test")
    @Test
    public void mathsShort() {
        String expected = "a=πr²";
        assertEquals(expected, MicroBlog.truncate("a=πr²"));
    }

    @Ignore("Remove to run test")
    @Test
    public void mathsLong() {
        String expected = "∅⊊ℕ⊊ℤ";
        assertEquals(expected, MicroBlog.truncate("∅⊊ℕ⊊ℤ⊊ℚ⊊ℝ⊊ℂ"));
    }
    
    @Ignore("Remove to run test")
    @Test
    public void englishAndEmojiShort() {
        String expected = "Fly 🛫";
        assertEquals(expected, MicroBlog.truncate("Fly 🛫"));
    }
    
    @Ignore("Remove to run test")
    @Test
    public void emojiShort() {
        String expected = "💇";
        assertEquals(expected, MicroBlog.truncate("💇"));
    }
    
    @Ignore("Remove to run test")
    @Test
    public void emojiLong() {
        String expected = "❄🌡🤧🤒🏥";
        assertEquals(expected, MicroBlog.truncate("❄🌡🤧🤒🏥🕰😀"));
    }
    
    @Ignore("Remove to run test")
    @Test
    public void royalFlush() {
        String expected = "🃎🂸🃅🃋🃍";
        assertEquals(expected, MicroBlog.truncate("🃎🂸🃅🃋🃍🃁🃊"));
    }
}
