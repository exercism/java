import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class HouseTest {

    private House house;

    @Before
    public void setup() {
        house = new House();
    }

    @Test
    public void verseOne() {
        String expected = "This is the house that Jack built.";
        int verse = 1;

        assertEquals(expected, house.verse(verse));
    }

    @Ignore("Remove to run test")
    @Test
    public void verseTwo() {
        String expected =
                "This is the malt " +
                "that lay in the house that Jack built.";
        int verse = 2;

        assertEquals(expected, house.verse(verse));
    }

    @Ignore("Remove to run test")
    @Test
    public void verseThree() {
        String expected =
                "This is the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.";
        int verse = 3;

        assertEquals(expected, house.verse(verse));
    }

    @Ignore("Remove to run test")
    @Test
    public void verseFour() {
        String expected =
                "This is the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.";
        int verse = 4;

        assertEquals(expected, house.verse(verse));
    }

    @Ignore("Remove to run test")
    @Test
    public void verseFive() {
        String expected =
                "This is the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.";
        int verse = 5;

        assertEquals(expected, house.verse(verse));
    }

    @Ignore("Remove to run test")
    @Test
    public void verseSix() {
        String expected =
                "This is the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.";
        int verse = 6;

        assertEquals(expected, house.verse(verse));
    }

    @Ignore("Remove to run test")
    @Test
    public void verseSeven() {
        String expected =
                "This is the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.";
        int verse = 7;

        assertEquals(expected, house.verse(verse));
    }

    @Ignore("Remove to run test")
    @Test
    public void verseEight() {
        String expected =
                "This is the man all tattered and torn " +
                "that kissed the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.";
        int verse = 8;

        assertEquals(expected, house.verse(verse));
    }

    @Ignore("Remove to run test")
    @Test
    public void verseNine() {
        String expected =
                "This is the priest all shaven and shorn " +
                "that married the man all tattered and torn " +
                "that kissed the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.";
        int verse = 9;

        assertEquals(expected, house.verse(verse));
    }

    @Ignore("Remove to run test")
    @Test
    public void verse10() {
        String expected =
                "This is the rooster that crowed in the morn " +
                "that woke the priest all shaven and shorn " +
                "that married the man all tattered and torn " +
                "that kissed the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.";
        int verse = 10;

        assertEquals(expected, house.verse(verse));
    }

    @Ignore("Remove to run test")
    @Test
    public void verse11() {
        String expected =
                "This is the farmer sowing his corn " +
                "that kept the rooster that crowed in the morn " +
                "that woke the priest all shaven and shorn " +
                "that married the man all tattered and torn " +
                "that kissed the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.";
        int verse = 11;

        assertEquals(expected, house.verse(verse));
    }

    @Ignore("Remove to run test")
    @Test
    public void verse12() {
        String expected =
                "This is the horse and the hound and the horn " +
                "that belonged to the farmer sowing his corn " +
                "that kept the rooster that crowed in the morn " +
                "that woke the priest all shaven and shorn " +
                "that married the man all tattered and torn " +
                "that kissed the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.";
        int verse = 12;

        assertEquals(expected, house.verse(verse));
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleVerses() {
        String expected =
                "This is the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the man all tattered and torn " +
                "that kissed the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.";

        int startVerse = 4;
        int endVerse = 8;

        assertEquals(expected, house.verses(startVerse, endVerse));
    }

    @Ignore("Remove to run test")
    @Test
    public void wholeRhyme() {
        String expected =
                "This is the house that Jack built.\n" +
                "This is the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the man all tattered and torn " +
                "that kissed the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the priest all shaven and shorn " +
                "that married the man all tattered and torn " +
                "that kissed the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the rooster that crowed in the morn " +
                "that woke the priest all shaven and shorn " +
                "that married the man all tattered and torn " +
                "that kissed the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the farmer sowing his corn " +
                "that kept the rooster that crowed in the morn " +
                "that woke the priest all shaven and shorn " +
                "that married the man all tattered and torn " +
                "that kissed the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.\n" +
                "This is the horse and the hound and the horn " +
                "that belonged to the farmer sowing his corn " +
                "that kept the rooster that crowed in the morn " +
                "that woke the priest all shaven and shorn " +
                "that married the man all tattered and torn " +
                "that kissed the maiden all forlorn " +
                "that milked the cow with the crumpled horn " +
                "that tossed the dog " +
                "that worried the cat " +
                "that killed the rat " +
                "that ate the malt " +
                "that lay in the house that Jack built.";

        assertEquals(expected, house.sing());
    }
}
