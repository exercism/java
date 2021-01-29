import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;

import static org.junit.Assert.*;

public class BobTest {
    private Bob bob;


    @Before
    public void setUp() {
        bob = new Bob();
    }

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
    public void shoutingGibberish() {
        assertEquals(
            "Whoa, chill out!",
            bob.hey("FCECDFCAAB")
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
    public void askingGibberish() {
        assertEquals(
            "Sure.",
            bob.hey("fffbbcbeab?")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void talkingForcefully() {
        assertEquals(
            "Whatever.",
            bob.hey("Hi there!")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void usingAcronymsInRegularSpeech() {
        assertEquals(
            "Whatever.", bob.hey("It's OK if you don't want to go work for NASA.")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void forcefulQuestions() {
        assertEquals(
            "Calm down, I know what I'm doing!", bob.hey("WHAT'S GOING ON?")
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
    public void shoutingWithNoExclamationMark() {
        assertEquals(
            "Whoa, chill out!", bob.hey("I HATE THE DENTIST")
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
    public void nonLettersWithQuestion() {
        assertEquals(
            "Sure.", bob.hey(":) ?")
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
            "Fine. Be that way!", bob.hey("          ")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void alternateSilence() {
        assertEquals(
            "Fine. Be that way!", bob.hey("\t\t\t\t\t\t\t\t\t\t")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleLineQuestion() {
        assertEquals(
            "Whatever.",
            bob.hey("\nDoes this cryogenic chamber make me look fat?\nNo.")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void startingWithWhitespace() {
        assertEquals(
            "Whatever.",
            bob.hey("         hmmmmmmm...")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void endingWithWhiteSpace() {
        assertEquals(
            "Sure.",
            bob.hey("Okay if like my  spacebar  quite a bit?   ")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void otherWhiteSpace() {
        assertEquals(
            "Fine. Be that way!",
            bob.hey("\n\r \t")
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void nonQuestionEndingWithWhiteSpace() {
        assertEquals(
            "Whatever.",
            bob.hey("This is a statement ending with whitespace      ")
        );
    }

}
