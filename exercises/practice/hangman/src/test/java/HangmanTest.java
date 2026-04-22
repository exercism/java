import io.reactivex.Observable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Output result = hangman
                .guess("loot", Observable.empty())
                .blockingLast();

        assertEquals(Status.ON_GOING, result.state);
        assertEquals("____", result.maskedWord);
        assertEquals(9, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("After 10 failures the game is over")
    void after10FailuresTheGameIsOver() {
        Output result = hangman
                .guess("loot", Observable.fromArray("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"))
                .blockingLast();

        assertEquals(Status.LOSE, result.state);
        assertEquals("____", result.maskedWord);
        assertEquals(0, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Losing with several correct guesses")
    void losingWithSeveralCorrectGuesses() {
        Output result = hangman
                .guess("loot", Observable.fromArray("t", "o", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"))
                .blockingLast();

        assertEquals(Status.LOSE, result.state);
        assertEquals("_oot", result.maskedWord);
        assertEquals(0, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Feeding a correct letter removes underscores")
    void feedingCorrectLetterRemovesUnderscores() {
        Output result = hangman
                .guess("loot", Observable.fromArray("t"))
                .blockingLast();

        assertEquals(Status.ON_GOING, result.state);
        assertEquals("___t", result.maskedWord);
        assertEquals(9, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Feeding a correct letter twice counts as a failure")
    void feedingCorrectLetterTwiceCountAsASuccess() {
        Output result = hangman
                .guess("loot", Observable.fromArray("t", "t"))
                .blockingLast();

        assertEquals(Status.ON_GOING, result.state);
        assertEquals("___t", result.maskedWord);
        assertEquals(8, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Guessing a repeated letter reveals all instances")
    void guessingARepeatedLetterRevealsAllInstances() {
        Output result = hangman
                .guess("loot", Observable.fromArray("t", "t", "o"))
                .blockingLast();

        assertEquals(Status.ON_GOING, result.state);
        assertEquals("_oot", result.maskedWord);
        assertEquals(8, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Getting all the letters right makes for a win")
    void gettingAllTheLettersRightMakesForASuccess() {
        Output result = hangman
                .guess("loot", Observable.fromArray("t", "t", "o", "l"))
                .blockingLast();

        assertEquals(Status.WIN, result.state);
        assertEquals("loot", result.maskedWord);
        assertEquals(8, result.remainingFailures);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Winning on the last guess is still a win")
    void winningOnTheLastGuessIsStillAWin() {
        Output result = hangman
                .guess("loot", Observable.fromArray("a", "b", "c", "d", "e", "f", "g", "h", "i", "t", "o", "l"))
                .blockingLast();

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
                () -> hangman
                        .guess("loot", Observable.fromArray("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"))
                        .blockingLast()
        );

        assertEquals("cannot guess after the game is lost", ex.getMessage());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Guessing after a win is error")
    void guessingAfterAWinIsError() {
        IllegalStateException ex = assertThrows(
                IllegalStateException.class,
                () -> hangman
                        .guess("loot", Observable.fromArray("t", "o", "l", "l"))
                        .blockingLast()
        );

        assertEquals("cannot guess after the game is won", ex.getMessage());
    }
}
