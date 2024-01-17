import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

public class BottleSongTest {

    private BottleSong bottleSong;

    @BeforeEach
    public void setup() {
        bottleSong = new BottleSong();
    }

    @Test
    public void firstGenericVerse() {
        assertThat(bottleSong.recite(10, 1)).isEqualTo(
            "Ten green bottles hanging on the wall,\n" +
            "Ten green bottles hanging on the wall,\n" +
            "And if one green bottle should accidentally fall,\n" +
            "There'll be nine green bottles hanging on the wall.\n"
        );
    }

    @Disabled("Remove to run test")
    @Test
    public void lastGenericVerse() {
        assertThat(bottleSong.recite(3, 1)).isEqualTo(
            "Three green bottles hanging on the wall,\n" +
            "Three green bottles hanging on the wall,\n" +
            "And if one green bottle should accidentally fall,\n" +
            "There'll be two green bottles hanging on the wall.\n"
        );
    }

    @Disabled("Remove to run test")
    @Test
    public void verseWithTwoBottles() {
        assertThat(bottleSong.recite(2, 1)).isEqualTo(
            "Two green bottles hanging on the wall,\n" +
            "Two green bottles hanging on the wall,\n" +
            "And if one green bottle should accidentally fall,\n" +
            "There'll be one green bottle hanging on the wall.\n"
        );
    }

    @Disabled("Remove to run test")
    @Test
    public void verseWithOneBottle() {
        assertThat(bottleSong.recite(1, 1)).isEqualTo(
            "One green bottle hanging on the wall,\n" +
            "One green bottle hanging on the wall,\n" +
            "And if one green bottle should accidentally fall,\n" +
            "There'll be no green bottles hanging on the wall.\n"
        );
    }

    @Disabled("Remove to run test")
    @Test
    public void firstTwoVerses() {
        assertThat(bottleSong.recite(10, 2)).isEqualTo(
            "Ten green bottles hanging on the wall,\n" +
            "Ten green bottles hanging on the wall,\n" +
            "And if one green bottle should accidentally fall,\n" +
            "There'll be nine green bottles hanging on the wall.\n" +
            "\n" +
            "Nine green bottles hanging on the wall,\n" +
            "Nine green bottles hanging on the wall,\n" +
            "And if one green bottle should accidentally fall,\n" +
            "There'll be eight green bottles hanging on the wall.\n"
        );
    }

    @Disabled("Remove to run test")
    @Test
    public void lastThreeVerses() {
        assertThat(bottleSong.recite(3, 3)).isEqualTo(
            "Three green bottles hanging on the wall,\n" +
            "Three green bottles hanging on the wall,\n" +
            "And if one green bottle should accidentally fall,\n" +
            "There'll be two green bottles hanging on the wall.\n" +
            "\n" +
            "Two green bottles hanging on the wall,\n" +
            "Two green bottles hanging on the wall,\n" +
            "And if one green bottle should accidentally fall,\n" +
            "There'll be one green bottle hanging on the wall.\n" +
            "\n" +
            "One green bottle hanging on the wall,\n" +
            "One green bottle hanging on the wall,\n" +
            "And if one green bottle should accidentally fall,\n" +
            "There'll be no green bottles hanging on the wall.\n"
        );
    }

    @Disabled("Remove to run test")
    @Test
    public void allVerses() {
        assertThat(bottleSong.recite(10, 10))
            .isEqualTo(
                "Ten green bottles hanging on the wall,\n" +
                "Ten green bottles hanging on the wall,\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be nine green bottles hanging on the wall.\n" +
                "\n" +
                "Nine green bottles hanging on the wall,\n" +
                "Nine green bottles hanging on the wall,\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be eight green bottles hanging on the wall.\n" +
                "\n" +
                "Eight green bottles hanging on the wall,\n" +
                "Eight green bottles hanging on the wall,\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be seven green bottles hanging on the wall.\n" +
                "\n" +
                "Seven green bottles hanging on the wall,\n" +
                "Seven green bottles hanging on the wall,\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be six green bottles hanging on the wall.\n" +
                "\n" +
                "Six green bottles hanging on the wall,\n" +
                "Six green bottles hanging on the wall,\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be five green bottles hanging on the wall.\n" +
                "\n" +
                "Five green bottles hanging on the wall,\n" +
                "Five green bottles hanging on the wall,\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be four green bottles hanging on the wall.\n" +
                "\n" +
                "Four green bottles hanging on the wall,\n" +
                "Four green bottles hanging on the wall,\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be three green bottles hanging on the wall.\n" +
                "\n" +
                "Three green bottles hanging on the wall,\n" +
                "Three green bottles hanging on the wall,\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be two green bottles hanging on the wall.\n" +
                "\n" +
                "Two green bottles hanging on the wall,\n" +
                "Two green bottles hanging on the wall,\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be one green bottle hanging on the wall.\n" +
                "\n" +
                "One green bottle hanging on the wall,\n" +
                "One green bottle hanging on the wall,\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be no green bottles hanging on the wall.\n"
            );
    }
}
