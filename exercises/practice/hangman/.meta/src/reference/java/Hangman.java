import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class Hangman {

    Output guess(
        String word,
        List<String> letters) {

        Output state = createNewGame(word);

        for (String letter : letters) {
            if (state.state == Status.WIN) {
                throw new IllegalStateException("cannot guess after the game is won");
            }

            if (state.state == Status.LOSE) {
                throw new IllegalStateException("cannot guess after the game is lost");
            }

            state = processNewLetter(state, letter);
        }

        return state;
    }

    private static Output createNewGame(String word) {
        return Output.initialState(word);
    }

    private static Output processNewLetter(Output state, String letter) {
        if (state.isLetterAlreadyPlayed(letter)) {
            return processIncorrectGuess(state, letter);
        }

        if (state.isLetterInSecret(letter)) {
            return processCorrectGuess(state, letter);
        }

        return processIncorrectGuess(state, letter);
    }

    private static Output processCorrectGuess(Output state, String letter) {
        Set<String> newGuesses = new LinkedHashSet<>(state.guesses);
        newGuesses.add(letter);

        String discovered = Output.getGuessedWord(state.word, newGuesses);
        Status newStatus = Output.isWin(state.word, newGuesses) ? Status.WIN : Status.ON_GOING;

        return new Output(
            state.word,
            discovered,
            newGuesses,
            state.misses,
            state.parts,
            newStatus);
    }

    private static Output processIncorrectGuess(Output state, String letter) {
        Set<String> newMisses = new LinkedHashSet<>(state.misses);
        newMisses.add(letter);

        List<Part> newParts = new ArrayList<>(state.parts);
        if (newParts.size() < order.length) {
            newParts.add(order[newParts.size()]);
        }

        Status newStatus = newParts.size() >= order.length ? Status.LOSE : Status.ON_GOING;

        return new Output(
            state.word,
            state.maskedWord,
            state.guesses,
            newMisses,
            newParts,
            newStatus);
    }

    static Part[] order = Part.values();
}
