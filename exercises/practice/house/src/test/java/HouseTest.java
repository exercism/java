import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;

import static org.assertj.core.api.Assertions.assertThat;

public class HouseTest {

    private House house;

    @Before
    public void setup() {
        house = new House();
    }

    @Test
    public void verseOne() {
        assertThat(house.verse(1)).isEqualTo(
            "This is the house that Jack built.");
    }

    @Ignore("Remove to run test")
    @Test
    public void verseTwo() {
        assertThat(house.verse(2)).isEqualTo(
            "This is the malt " +
            "that lay in the house that Jack built."
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void verseThree() {
        assertThat(house.verse(3)).isEqualTo(
            "This is the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Ignore("Remove to run test")
    @Test
    public void verseFour() {
        assertThat(house.verse(4)).isEqualTo(
            "This is the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Ignore("Remove to run test")
    @Test
    public void verseFive() {
        assertThat(house.verse(5)).isEqualTo(
            "This is the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Ignore("Remove to run test")
    @Test
    public void verseSix() {
        assertThat(house.verse(6)).isEqualTo(
            "This is the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Ignore("Remove to run test")
    @Test
    public void verseSeven() {
        assertThat(house.verse(7)).isEqualTo(
            "This is the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Ignore("Remove to run test")
    @Test
    public void verseEight() {
        assertThat(house.verse(8)).isEqualTo(
            "This is the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Ignore("Remove to run test")
    @Test
    public void verseNine() {
        assertThat(house.verse(9)).isEqualTo(
            "This is the priest all shaven and shorn " +
            "that married the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Ignore("Remove to run test")
    @Test
    public void verse10() {
        assertThat(house.verse(10)).isEqualTo(
            "This is the rooster that crowed in the morn " +
            "that woke the priest all shaven and shorn " +
            "that married the man all tattered and torn " +
            "that kissed the maiden all forlorn " +
            "that milked the cow with the crumpled horn " +
            "that tossed the dog " +
            "that worried the cat " +
            "that killed the rat " +
            "that ate the malt " +
            "that lay in the house that Jack built.");
    }

    @Ignore("Remove to run test")
    @Test
    public void verse11() {
        assertThat(house.verse(11)).isEqualTo(
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
            "that lay in the house that Jack built.");
    }

    @Ignore("Remove to run test")
    @Test
    public void verse12() {
        assertThat(house.verse(12)).isEqualTo(
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
            "that lay in the house that Jack built.");
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleVerses() {
        int startVerse = 4;
        int endVerse = 8;

        assertThat(house.verses(startVerse, endVerse)).isEqualTo(
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
            "that lay in the house that Jack built.");
    }

    @Ignore("Remove to run test")
    @Test
    public void wholeRhyme() {
        assertThat(house.sing()).isEqualTo(
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
            "that lay in the house that Jack built.");
    }
}
