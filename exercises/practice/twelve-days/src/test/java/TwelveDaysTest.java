import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwelveDaysTest {
    private TwelveDays twelveDays;

    @BeforeEach
    public void setup() {
        twelveDays = new TwelveDays();
    }

    @Test
    public void testVerseOne() {
        String expectedVerseOne = "On the first day of Christmas my true love gave to me: " +
                "a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verse(1)).isEqualTo(expectedVerseOne);
    }

    @Disabled("Remove to run test")
    @Test
    public void testVerseTwo() {
        String expectedVerseTwo = "On the second day of Christmas my true love gave to me: two Turtle Doves, " +
                "and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verse(2)).isEqualTo(expectedVerseTwo);
    }

    @Disabled("Remove to run test")
    @Test
    public void testVerseThree() {
        String expectedVerseThree = "On the third day of Christmas my true love gave to me: three French Hens, " +
                "two Turtle Doves, and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verse(3)).isEqualTo(expectedVerseThree);
    }

    @Disabled("Remove to run test")
    @Test
    public void testVerseFour() {
        String expectedVerseFour = "On the fourth day of Christmas my true love gave to me: four Calling Birds, " +
                "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verse(4)).isEqualTo(expectedVerseFour);
    }

    @Disabled("Remove to run test")
    @Test
    public void testVerseFive() {
        String expectedVerseFive = "On the fifth day of Christmas my true love gave to me: five Gold Rings, " +
                "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verse(5)).isEqualTo(expectedVerseFive);
    }

    @Disabled("Remove to run test")
    @Test
    public void testVerseSix() {
        String expectedVerseSix = "On the sixth day of Christmas my true love gave to me: six Geese-a-Laying, " +
                "five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, " +
                "and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verse(6)).isEqualTo(expectedVerseSix);
    }

    @Disabled("Remove to run test")
    @Test
    public void testVerseSeven() {
        String expectedVerseSeven = "On the seventh day of Christmas my true love gave to me: " +
                "seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, " +
                "two Turtle Doves, and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verse(7)).isEqualTo(expectedVerseSeven);
    }

    @Disabled("Remove to run test")
    @Test
    public void testVerseEight() {
        String expectedVerseEight = "On the eighth day of Christmas my true love gave to me: eight Maids-a-Milking," +
                " seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, " +
                "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verse(8)).isEqualTo(expectedVerseEight);
    }

    @Disabled("Remove to run test")
    @Test
    public void testVerseNine() {
        String expectedVerseNine = "On the ninth day of Christmas my true love gave to me: nine Ladies Dancing, " +
                "eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, " +
                "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verse(9)).isEqualTo(expectedVerseNine);
    }

    @Disabled("Remove to run test")
    @Test
    public void testVerseTen() {
        String expectedVerseTen = "On the tenth day of Christmas my true love gave to me: ten Lords-a-Leaping, " +
                "nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, " +
                "five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, " +
                "and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verse(10)).isEqualTo(expectedVerseTen);
    }

    @Disabled("Remove to run test")
    @Test
    public void testVerseEleven() {
        String expectedVerseEleven = "On the eleventh day of Christmas my true love gave to me: " +
                "eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, " +
                "seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, " +
                "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verse(11)).isEqualTo(expectedVerseEleven);
    }

    @Disabled("Remove to run test")
    @Test
    public void testVerseTwelve() {
        String expectedVerseTwelve = "On the twelfth day of Christmas my true love gave to me: " +
                "twelve Drummers Drumming, eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, " +
                "eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, " +
                "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verse(12)).isEqualTo(expectedVerseTwelve);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFirstThreeVerses() {
        String expectedVersesOneToThree = "On the first day of Christmas my true love gave to me: " +
                "a Partridge in a Pear Tree.\n\n" +
                "On the second day of Christmas my true love gave to me: two Turtle Doves, " +
                "and a Partridge in a Pear Tree.\n\n" +
                "On the third day of Christmas my true love gave to me: three French Hens, two Turtle Doves, " +
                "and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verses(1, 3)).isEqualTo(expectedVersesOneToThree);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFourthToSixthVerses() {
        String expectedVersesFourToSix = "On the fourth day of Christmas my true love gave to me: " + 
                "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n\n" +
                "On the fifth day of Christmas my true love gave to me: five Gold Rings, four Calling Birds, " + 
                "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n\n" +
                "On the sixth day of Christmas my true love gave to me: six Geese-a-Laying, five Gold Rings, " + 
                "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.verses(4, 6)).isEqualTo(expectedVersesFourToSix);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSingWholeSong() {
        String expectedSong = "On the first day of Christmas my true love gave to me: a Partridge in a Pear Tree.\n" +
                "\n" +
                "On the second day of Christmas my true love gave to me: two Turtle Doves, " +
                "and a Partridge in a Pear Tree.\n" +
                "\n" +
                "On the third day of Christmas my true love gave to me: three French Hens, two Turtle Doves, " +
                "and a Partridge in a Pear Tree.\n" +
                "\n" +
                "On the fourth day of Christmas my true love gave to me: four Calling Birds, three French Hens, " +
                "two Turtle Doves, and a Partridge in a Pear Tree.\n" +
                "\n" +
                "On the fifth day of Christmas my true love gave to me: five Gold Rings, four Calling Birds, " +
                "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n" +
                "\n" +
                "On the sixth day of Christmas my true love gave to me: six Geese-a-Laying, five Gold Rings, " +
                "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n" +
                "\n" +
                "On the seventh day of Christmas my true love gave to me: seven Swans-a-Swimming, " +
                "six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, " +
                "and a Partridge in a Pear Tree.\n" +
                "\n" +
                "On the eighth day of Christmas my true love gave to me: eight Maids-a-Milking, " +
                "seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, " +
                "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n" +
                "\n" +
                "On the ninth day of Christmas my true love gave to me: nine Ladies Dancing, eight Maids-a-Milking," +
                " seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, " +
                "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n" +
                "\n" +
                "On the tenth day of Christmas my true love gave to me: ten Lords-a-Leaping, nine Ladies Dancing," +
                " eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, " +
                "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n" +
                "\n" +
                "On the eleventh day of Christmas my true love gave to me: eleven Pipers Piping, " +
                "ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, " +
                "six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, " +
                "and a Partridge in a Pear Tree.\n" +
                "\n" +
                "On the twelfth day of Christmas my true love gave to me: twelve Drummers Drumming, " +
                "eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, " +
                "seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, " +
                "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n";
        assertThat(twelveDays.sing()).isEqualTo(expectedSong);
    }
}
