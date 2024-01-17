import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FoodChainTest {
    private FoodChain foodChain;

    @BeforeEach
    public void setup() {
        foodChain = new FoodChain();
    }

    @Test
    public void fly() {
        int verse = 1;
        String expected = "I know an old lady who swallowed a fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.";

        assertThat(foodChain.verse(verse)).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test.")
    public void spider() {
        int verse = 2;
        String expected = "I know an old lady who swallowed a spider.\n" +
                          "It wriggled and jiggled and tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.";

        assertThat(foodChain.verse(verse)).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test.")
    public void bird() {
        int verse = 3;
        String expected = "I know an old lady who swallowed a bird.\n" +
                          "How absurd to swallow a bird!\n" +
                          "She swallowed the bird to catch the spider that wriggled and jiggled and " +
                          "tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.";

        assertThat(foodChain.verse(verse)).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test.")
    public void cat() {
        int verse = 4;
        String expected = "I know an old lady who swallowed a cat.\n" +
                          "Imagine that, to swallow a cat!\n" +
                          "She swallowed the cat to catch the bird.\n" +
                          "She swallowed the bird to catch the spider that wriggled and jiggled and " +
                          "tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.";

        assertThat(foodChain.verse(verse)).isEqualTo(expected);
    }


    @Test
    @Disabled("Remove to run test.")
    public void dog() {
        int verse = 5;
        String expected = "I know an old lady who swallowed a dog.\n" +
                          "What a hog, to swallow a dog!\n" +
                          "She swallowed the dog to catch the cat.\n" +
                          "She swallowed the cat to catch the bird.\n" +
                          "She swallowed the bird to catch the spider that wriggled and jiggled and " +
                          "tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.";

        assertThat(foodChain.verse(verse)).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test.")
    public void goat() {
        int verse = 6;
        String expected = "I know an old lady who swallowed a goat.\n" +
                          "Just opened her throat and swallowed a goat!\n" +
                          "She swallowed the goat to catch the dog.\n" +
                          "She swallowed the dog to catch the cat.\n" +
                          "She swallowed the cat to catch the bird.\n" +
                          "She swallowed the bird to catch the spider that wriggled and jiggled and " +
                          "tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.";

        assertThat(foodChain.verse(verse)).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test.")
    public void cow() {
        int verse = 7;
        String expected = "I know an old lady who swallowed a cow.\n" +
                          "I don't know how she swallowed a cow!\n" +
                          "She swallowed the cow to catch the goat.\n" +
                          "She swallowed the goat to catch the dog.\n" +
                          "She swallowed the dog to catch the cat.\n" +
                          "She swallowed the cat to catch the bird.\n" +
                          "She swallowed the bird to catch the spider that wriggled and jiggled and " +
                          "tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.";

        assertThat(foodChain.verse(verse)).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test.")
    public void horse() {
        int verse = 8;
        String expected = "I know an old lady who swallowed a horse.\n" +
                          "She's dead, of course!";

        assertThat(foodChain.verse(verse)).isEqualTo(expected);
    }


    @Test
    @Disabled("Remove to run test.")
    public void multipleVerses() {
        int startVerse = 1;
        int endVerse = 3;
        String expected = "I know an old lady who swallowed a fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.\n" +
                          "\n" +
                          "I know an old lady who swallowed a spider.\n" +
                          "It wriggled and jiggled and tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.\n" +
                          "\n" +
                          "I know an old lady who swallowed a bird.\n" +
                          "How absurd to swallow a bird!\n" +
                          "She swallowed the bird to catch the spider that wriggled and jiggled and " +
                          "tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.";

        assertThat(foodChain.verses(startVerse, endVerse)).isEqualTo(expected);
    }


    @Test
    @Disabled("Remove to run test.")
    public void wholeSong() {
        int startVerse = 1;
        int endVerse = 8;
        String expected = "I know an old lady who swallowed a fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.\n" +
                          "\n" +
                          "I know an old lady who swallowed a spider.\n" +
                          "It wriggled and jiggled and tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.\n" +
                          "\n" +
                          "I know an old lady who swallowed a bird.\n" +
                          "How absurd to swallow a bird!\n" +
                          "She swallowed the bird to catch the spider that wriggled and jiggled and " +
                          "tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.\n" +
                          "\n" +
                          "I know an old lady who swallowed a cat.\n" +
                          "Imagine that, to swallow a cat!\n" +
                          "She swallowed the cat to catch the bird.\n" +
                          "She swallowed the bird to catch the spider that wriggled and jiggled and " +
                          "tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.\n" +
                          "\n" +
                          "I know an old lady who swallowed a dog.\n" +
                          "What a hog, to swallow a dog!\n" +
                          "She swallowed the dog to catch the cat.\n" +
                          "She swallowed the cat to catch the bird.\n" +
                          "She swallowed the bird to catch the spider that wriggled and jiggled and " +
                          "tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.\n" +
                          "\n" +
                          "I know an old lady who swallowed a goat.\n" +
                          "Just opened her throat and swallowed a goat!\n" +
                          "She swallowed the goat to catch the dog.\n" +
                          "She swallowed the dog to catch the cat.\n" +
                          "She swallowed the cat to catch the bird.\n" +
                          "She swallowed the bird to catch the spider that wriggled and jiggled and " +
                          "tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.\n" +
                          "\n" +
                          "I know an old lady who swallowed a cow.\n" +
                          "I don't know how she swallowed a cow!\n" +
                          "She swallowed the cow to catch the goat.\n" +
                          "She swallowed the goat to catch the dog.\n" +
                          "She swallowed the dog to catch the cat.\n" +
                          "She swallowed the cat to catch the bird.\n" +
                          "She swallowed the bird to catch the spider that wriggled and jiggled and " +
                          "tickled inside her.\n" +
                          "She swallowed the spider to catch the fly.\n" +
                          "I don't know why she swallowed the fly. Perhaps she'll die.\n" +
                          "\n" +
                          "I know an old lady who swallowed a horse.\n" +
                          "She's dead, of course!";

        assertThat(foodChain.verses(startVerse, endVerse)).isEqualTo(expected);
    }
}
