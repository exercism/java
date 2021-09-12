import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;

import static org.assertj.core.api.Assertions.assertThat;


public class BobTest {
    private Bob bob;

    @Before
    public void setUp() {
        bob = new Bob();
    }

    @Test
    public void saySomething() {
        assertThat(bob.hey("Tom-ay-to, tom-aaaah-to."))
                .isEqualTo("Whatever.");
    }

    @Ignore("Remove to run test")
    @Test
    public void shouting() {
        assertThat(bob.hey("WATCH OUT!"))
                .isEqualTo("Whoa, chill out!");
    }

    @Ignore("Remove to run test")
    @Test
    public void shoutingGibberish() {
        assertThat(bob.hey("FCECDFCAAB"))
                .isEqualTo("Whoa, chill out!");
    }

    @Ignore("Remove to run test")
    @Test
    public void askingAQuestion() {
        assertThat(bob.hey("Does this cryogenic chamber make me look fat?"))
                .isEqualTo("Sure.");
    }

    @Ignore("Remove to run test")
    @Test
    public void askingANumericQuestion() {
        assertThat(bob.hey("You are, what, like 15?"))
                .isEqualTo("Sure.");
    }

    @Ignore("Remove to run test")
    @Test
    public void askingGibberish() {
        assertThat(bob.hey("fffbbcbeab?"))
                .isEqualTo("Sure.");
    }

    @Ignore("Remove to run test")
    @Test
    public void talkingForcefully() {
        assertThat(bob.hey("Hi there!"))
                .isEqualTo("Whatever.");
    }

    @Ignore("Remove to run test")
    @Test
    public void usingAcronymsInRegularSpeech() {
        assertThat(bob.hey("It's OK if you don't want to go work for NASA."))
                .isEqualTo("Whatever.");
    }

    @Ignore("Remove to run test")
    @Test
    public void forcefulQuestions() {
        assertThat(bob.hey("WHAT'S GOING ON?"))
                .isEqualTo("Calm down, I know what I'm doing!");
    }

    @Ignore("Remove to run test")
    @Test
    public void shoutingNumbers() {
        assertThat(bob.hey("1, 2, 3 GO!"))
                .isEqualTo("Whoa, chill out!");
    }

    @Ignore("Remove to run test")
    @Test
    public void onlyNumbers() {
        assertThat(bob.hey("1, 2, 3"))
                .isEqualTo("Whatever.");
    }

    @Ignore("Remove to run test")
    @Test
    public void questionWithOnlyNumbers() {
        assertThat(bob.hey("4?"))
                .isEqualTo("Sure.");
    }

    @Ignore("Remove to run test")
    @Test
    public void shoutingWithSpecialCharacters() {
        assertThat(bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!"))
                .isEqualTo("Whoa, chill out!");
    }

    @Ignore("Remove to run test")
    @Test
    public void shoutingWithNoExclamationMark() {
        assertThat(bob.hey("I HATE THE DENTIST"))
                .isEqualTo("Whoa, chill out!");
    }

    @Ignore("Remove to run test")
    @Test
    public void statementContainingQuestionMark() {
        assertThat(bob.hey("Ending with ? means a question."))
                .isEqualTo("Whatever.");
    }

    @Ignore("Remove to run test")
    @Test
    public void nonLettersWithQuestion() {
        assertThat(bob.hey(":) ?"))
                .isEqualTo("Sure.");
    }

    @Ignore("Remove to run test")
    @Test
    public void prattlingOn() {
        assertThat(bob.hey("Wait! Hang on. Are you going to be OK?"))
                .isEqualTo("Sure.");
    }

    @Ignore("Remove to run test")
    @Test
    public void silence() {
        assertThat(bob.hey(""))
                .isEqualTo("Fine. Be that way!");
    }

    @Ignore("Remove to run test")
    @Test
    public void prolongedSilence() {
        assertThat(bob.hey("          "))
                .isEqualTo("Fine. Be that way!");
    }

    @Ignore("Remove to run test")
    @Test
    public void alternateSilence() {
        assertThat(bob.hey("\t\t\t\t\t\t\t\t\t\t"))
                .isEqualTo("Fine. Be that way!");
    }

    @Ignore("Remove to run test")
    @Test
    public void multipleLineQuestion() {
        assertThat(bob.hey("\nDoes this cryogenic chamber make me look fat?\nNo."))
                .isEqualTo("Whatever.");
    }

    @Ignore("Remove to run test")
    @Test
    public void startingWithWhitespace() {
        assertThat(bob.hey("         hmmmmmmm..."))
                .isEqualTo("Whatever.");
    }

    @Ignore("Remove to run test")
    @Test
    public void endingWithWhiteSpace() {
        assertThat(bob.hey("Okay if like my  spacebar  quite a bit?   "))
                .isEqualTo("Sure.");
    }

    @Ignore("Remove to run test")
    @Test
    public void otherWhiteSpace() {
        assertThat(bob.hey("\n\r \t"))
                .isEqualTo("Fine. Be that way!");
    }

    @Ignore("Remove to run test")
    @Test
    public void nonQuestionEndingWithWhiteSpace() {
        assertThat(bob.hey("This is a statement ending with whitespace      "))
                .isEqualTo("Whatever.");
    }

}
