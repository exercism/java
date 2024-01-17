import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MicroBlogTest {

    private final MicroBlog microBlog = new MicroBlog();
    
    @Test
    public void englishLanguageShort() {
        String expected = "Hi";
        assertThat(microBlog.truncate("Hi")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void englishLanguageLong() {
        String expected = "Hello";
        assertThat(microBlog.truncate("Hello there")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void germanLanguageShort_broth() {
        String expected = "brühe";
        assertThat(microBlog.truncate("brühe")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void germanLanguageLong_bearCarpet_to_beards() {
        String expected = "Bärte";
        assertThat(microBlog.truncate("Bärteppich")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void bulgarianLanguageShort_good() {
        String expected = "Добър";
        assertThat(microBlog.truncate("Добър")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void greekLanguageShort_health() {
        String expected = "υγειά";
        assertThat(microBlog.truncate("υγειά")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void mathsShort() {
        String expected = "a=πr²";
        assertThat(microBlog.truncate("a=πr²")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void mathsLong() {
        String expected = "∅⊊ℕ⊊ℤ";
        assertThat(microBlog.truncate("∅⊊ℕ⊊ℤ⊊ℚ⊊ℝ⊊ℂ")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void englishAndEmojiShort() {
        String expected = "Fly 🛫";
        assertThat(microBlog.truncate("Fly 🛫")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void emojiShort() {
        String expected = "💇";
        assertThat(microBlog.truncate("💇")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void emojiLong() {
        String expected = "❄🌡🤧🤒🏥";
        assertThat(microBlog.truncate("❄🌡🤧🤒🏥🕰😀")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void royalFlush() {
        String expected = "🃎🂸🃅🃋🃍";
        assertThat(microBlog.truncate("🃎🂸🃅🃋🃍🃁🃊")).isEqualTo(expected);
    }
}
