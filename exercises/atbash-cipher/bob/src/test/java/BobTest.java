import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class BobTest {
    private final Bob bob = new Bob();


    @Test
    public void saySomething() {
        assertEquals(
            "Whatever.",
            bob.hey("Tom-ay-to, tom-aaaah-to.")
        );
    }

    @Ignore
    @Test
    public void shouting() {
        assertEquals(
            "Whoa, chill out!",
            bob.hey("WATCH OUT!")
        );
    }

    @Ignore
    @Test
    public void askingAQuestion() {
        assertEquals(
            "Sure.",
            bob.hey("Does this cryogenic chamber make me look fat?")
        );
    }

    @Ignore
    @Test
    public void askingANumericQuestion() {
        assertEquals(
            "Sure.",
            bob.hey("You are, what, like 15?")
        );
    }

    @Ignore
    @Test
    public void talkingForcefully() {
        assertEquals(
            "Whatever.",
            bob.hey("Let's go make out behind the gym!")
        );
    }

    @Ignore
    @Test
    public void usingAcronymsInRegularSpeech() {
        assertEquals(
            "Whatever.", bob.hey("It's OK if you don't want to go to the DMV.")
        );
    }

    @Ignore
    @Test
    public void forcefulQuestions() {
        assertEquals(
            "Whoa, chill out!", bob.hey("WHAT THE HELL WERE YOU THINKING?")
        );
    }

    @Ignore
    @Test
    public void shoutingNumbers() {
        assertEquals(
            "Whoa, chill out!", bob.hey("1, 2, 3 GO!")
        );
    }

    @Ignore
    @Test
    public void onlyNumbers() {
        assertEquals(
            "Whatever.", bob.hey("1, 2, 3")
        );
    }

    @Ignore
    @Test
    public void questionWithOnlyNumbers() {
        assertEquals(
            "Sure.", bob.hey("4?")
        );
    }

    @Ignore
    @Test
    public void shoutingWithSpecialCharacters() {
        assertEquals(
            "Whoa, chill out!", bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!")
        );
    }

    @Ignore
    @Test
    public void shoutingWithUmlauts() {
        assertEquals(
            "Whoa, chill out!", bob.hey("\u00dcML\u00c4\u00dcTS!")
        );
    }

    @Ignore
    @Test
    public void calmlySpeakingWithUmlauts() {
        assertEquals(
            "Whatever.", bob.hey("\u00dcML\u00e4\u00dcTS!")
        );
    }

    @Ignore
    @Test
    public void shoutingWithNoExclamationMark() {
        assertEquals(
            "Whoa, chill out!", bob.hey("I HATE YOU")
        );
    }

    @Ignore
    @Test
    public void statementContainingQuestionMark() {
        assertEquals(
            "Whatever.", bob.hey("Ending with ? means a question.")
        );
    }

    @Ignore
    @Test
    public void prattlingOn() {
        assertEquals(
            "Sure.", bob.hey("Wait! Hang on. Are you going to be OK?")
        );
    }

    @Ignore
    @Test
    public void silence() {
        assertEquals(
            "Fine. Be that way!", bob.hey("")
        );
    }

    @Ignore
    @Test
    public void prolongedSilence() {
        assertEquals(
            "Fine. Be that way!", bob.hey("    ")
        );
    }
}
