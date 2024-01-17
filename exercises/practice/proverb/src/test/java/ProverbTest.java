import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ProverbTest {

    @Test
    public void zeroWordsAreGiven() {
        String[] words  = new String[0];

        assertThat(new Proverb(words).recite()).isEqualTo("");
    }

    @Disabled("Remove to run test")
    @Test
    public void singlePieceOfProverb() {
        String[] words  = new String[]{"nail"};

        assertThat(new Proverb(words).recite())
            .isEqualTo("And all for the want of a nail.");
    }

    @Disabled("Remove to run test")
    @Test
    public void twoPiecesOfProverb() {
        String[] words  = new String[]{"nail", "shoe"};

        assertThat(new Proverb(words).recite())
            .isEqualTo(
                "For want of a nail the shoe was lost.\n" +
                "And all for the want of a nail.");
    }

    @Disabled("Remove to run test")
    @Test
    public void shortChainOfConsequences() {
        String[] words  = new String[]{"nail", "shoe", "horse"};

        assertThat(new Proverb(words).recite())
            .isEqualTo(
                "For want of a nail the shoe was lost.\n" +
                "For want of a shoe the horse was lost.\n" +
                "And all for the want of a nail.");
    }

    @Disabled("Remove to run test")
    @Test
    public void fullProverb() {
        String[] words  = new String[]{"nail", "shoe", "horse", "rider", "message", "battle", "kingdom"};

        assertThat(new Proverb(words).recite())
            .isEqualTo(
                "For want of a nail the shoe was lost.\n" +
                "For want of a shoe the horse was lost.\n" +
                "For want of a horse the rider was lost.\n" +
                "For want of a rider the message was lost.\n" +
                "For want of a message the battle was lost.\n" +
                "For want of a battle the kingdom was lost.\n" +
                "And all for the want of a nail.");
    }

    @Disabled("Remove to run test")
    @Test
    public void fourPiecesModernizedProverb() {
        String[] words  = new String[]{"pin", "gun", "soldier", "battle"};

        assertThat(new Proverb(words).recite())
            .isEqualTo(
                "For want of a pin the gun was lost.\n" +
                "For want of a gun the soldier was lost.\n" +
                "For want of a soldier the battle was lost.\n" +
                "And all for the want of a pin.");
    }

}
