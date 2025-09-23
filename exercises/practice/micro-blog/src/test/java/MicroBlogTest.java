import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MicroBlogTest {

    private final MicroBlog microBlog = new MicroBlog();
    
    @Test
    @DisplayName("English language short")
    public void englishLanguageShort() {
        String expected = "Hi";
        assertThat(microBlog.truncate("Hi")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("English language long")
    public void englishLanguageLong() {
        String expected = "Hello";
        assertThat(microBlog.truncate("Hello there")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("German language short (broth)")
    public void germanLanguageShort_broth() {
        String expected = "brühe";
        assertThat(microBlog.truncate("brühe")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("German language long (bear carpet → beards)")
    public void germanLanguageLong_bearCarpet_to_beards() {
        String expected = "Bärte";
        assertThat(microBlog.truncate("Bärteppich")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Bulgarian language short (good)")
    public void bulgarianLanguageShort_good() {
        String expected = "Добър";
        assertThat(microBlog.truncate("Добър")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Greek language short (health)")
    public void greekLanguageShort_health() {
        String expected = "υγειά";
        assertThat(microBlog.truncate("υγειά")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Maths short")
    public void mathsShort() {
        String expected = "a=πr²";
        assertThat(microBlog.truncate("a=πr²")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Maths long")
    public void mathsLong() {
        String expected = "∅⊊ℕ⊊ℤ";
        assertThat(microBlog.truncate("∅⊊ℕ⊊ℤ⊊ℚ⊊ℝ⊊ℂ")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("English and emoji short")
    public void englishAndEmojiShort() {
        String expected = "Fly 🛫";
        assertThat(microBlog.truncate("Fly 🛫")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Emoji short")
    public void emojiShort() {
        String expected = "💇";
        assertThat(microBlog.truncate("💇")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Emoji long")
    public void emojiLong() {
        String expected = "❄🌡🤧🤒🏥";
        assertThat(microBlog.truncate("❄🌡🤧🤒🏥🕰😀")).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Royal Flush?")
    public void royalFlush() {
        String expected = "🃎🂸🃅🃋🃍";
        assertThat(microBlog.truncate("🃎🂸🃅🃋🃍🃁🃊")).isEqualTo(expected);
    }
}
