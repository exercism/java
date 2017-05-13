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

    @Ignore("Remove to run test")
    @Test
    public void shouting() {
        assertEquals(
            "Whoa, chill out!",
            bob.hey("WATCH OUT!")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void askingAQuestion() {
        assertEquals(
            "Sure.",
            bob.hey("Does this cryogenic chamber make me look fat?")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void askingANumericQuestion() {
        assertEquals(
            "Sure.",
            bob.hey("You are, what, like 15?")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void talkingForcefully() {
        assertEquals(
            "Whatever.",
            bob.hey("Let's go make out behind the gym!")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void usingAcronymsInRegularSpeech() {
        assertEquals(
            "Whatever.", bob.hey("It's OK if you don't want to go to the DMV.")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void forcefulQuestions() {
        assertEquals(
            "Whoa, chill out!", bob.hey("WHAT THE HELL WERE YOU THINKING?")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void shoutingNumbers() {
        assertEquals(
            "Whoa, chill out!", bob.hey("1, 2, 3 GO!")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void onlyNumbers() {
        assertEquals(
            "Whatever.", bob.hey("1, 2, 3")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void questionWithOnlyNumbers() {
        assertEquals(
            "Sure.", bob.hey("4?")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void shoutingWithSpecialCharacters() {
        assertEquals(
            "Whoa, chill out!", bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void shoutingWithUmlauts() {
        assertEquals(
            "Whoa, chill out!", bob.hey("\u00dcML\u00c4\u00dcTS!")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void calmlySpeakingWithUmlauts() {
        assertEquals(
            "Whatever.", bob.hey("\u00dcML\u00e4\u00dcTS!")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void shoutingWithNoExclamationMark() {
        assertEquals(
            "Whoa, chill out!", bob.hey("I HATE YOU")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void statementContainingQuestionMark() {
        assertEquals(
            "Whatever.", bob.hey("Ending with ? means a question.")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void prattlingOn() {
        assertEquals(
            "Sure.", bob.hey("Wait! Hang on. Are you going to be OK?")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void silence() {
        assertEquals(
            "Fine. Be that way!", bob.hey("")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void prolongedSilence() {
        assertEquals(
            "Fine. Be that way!", bob.hey("    ")
        );
    }
}
