import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HangmanTest {

    private Hangman hangman;

    @BeforeEach
    public void init() {
        hangman = new Hangman();
    }

    @Test
    @DisplayName("Initially 9 failures are allowed and no letters are guessed")
    void initially9FailuresAreAllowedAndNoLettersAreGuessed() {
        Output result = hangman.guess("loot", List.of());

        assertEquals(Status.ON_GOING, result.state);
        assertEquals("____", result.maskedWord);
        assertEquals(9, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("After 10 failures the game is over")
    void after10FailuresTheGameIsOver() {
        Output result = hangman.guess(
            "loot",
            List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
        );

        assertEquals(Status.LOSE, result.state);
        assertEquals("____", result.maskedWord);
        assertEquals(0, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Losing with several correct guesses")
    void losingWithSeveralCorrectGuesses() {
        Output result = hangman.guess(
            "loot",
            List.of("t", "o", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
        );

        assertEquals(Status.LOSE, result.state);
        assertEquals("_oot", result.maskedWord);
        assertEquals(0, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Feeding a correct letter removes underscores")
    void feedingCorrectLetterRemovesUnderscores() {
        Output result = hangman.guess("loot", List.of("t"));

        assertEquals(Status.ON_GOING, result.state);
        assertEquals("___t", result.maskedWord);
        assertEquals(9, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Feeding a correct letter twice counts as a failure")
    void feedingCorrectLetterTwiceCountAsASuccess() {
        Output result = hangman.guess("loot", List.of("t", "t"));

        assertEquals(Status.ON_GOING, result.state);
        assertEquals("___t", result.maskedWord);
        assertEquals(8, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Guessing a repeated letter reveals all instances")
    void guessingARepeatedLetterRevealsAllInstances() {
        Output result = hangman.guess("loot", List.of("t", "t", "o"));

        assertEquals(Status.ON_GOING, result.state);
        assertEquals("_oot", result.maskedWord);
        assertEquals(8, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Getting all the letters right makes for a win")
    void gettingAllTheLettersRightMakesForASuccess() {
        Output result = hangman.guess("loot", List.of("t", "t", "o", "l"));

        assertEquals(Status.WIN, result.state);
        assertEquals("loot", result.maskedWord);
        assertEquals(8, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Winning on the last guess is still a win")
    void winningOnTheLastGuessIsStillAWin() {
        Output result = hangman.guess(
            "loot",
            List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "t", "o", "l")
        );

        assertEquals(Status.WIN, result.state);
        assertEquals("loot", result.maskedWord);
        assertEquals(0, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Guessing after a lose is error")
    void guessingAfterALoseIsError() {
        IllegalStateException ex = assertThrows(
            IllegalStateException.class,
            () -> hangman.guess(
                "loot",
                List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")
            )
        );

        assertEquals("cannot guess after the game is lost", ex.getMessage());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Guessing after a win is error")
    void guessingAfterAWinIsError() {
        IllegalStateException ex = assertThrows(
            IllegalStateException.class,
            () -> hangman.guess("loot", List.of("t", "o", "l", "l"))
        );

        assertEquals("cannot guess after the game is won", ex.getMessage());
    }
}