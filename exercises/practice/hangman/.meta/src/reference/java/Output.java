import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.joining;

class Output {

    static final int MAX_FAILURES = Part.values().length;

    public final String word;
    public final String maskedWord;
    public final Set<String> guesses;
    public final Set<String> misses;
    public final List<Part> parts;
    public final Status state;
    public final int remainingFailures;

    Output(
        final String word,
        final String maskedWord,
        final Set<String> guesses,
        final Set<String> misses,
        final List<Part> parts,
        final Status state) {
        this.word = word;
        this.maskedWord = maskedWord;
        this.guesses = Set.copyOf(guesses);
        this.misses = Set.copyOf(misses);
        this.parts = List.copyOf(parts);
        this.state = state;
        this.remainingFailures = Math.max(0, MAX_FAILURES - 1 - parts.size());
    }

    static Output empty() {
        return new Output(
            null,
            null,
            Collections.emptySet(),
            Collections.emptySet(),
            Collections.emptyList(),
            null);
    }

    static Output initialState(final String secret) {
        return new Output(
            secret,
            getGuessedWord(secret, Collections.emptySet()),
            new LinkedHashSet<>(),
            new LinkedHashSet<>(),
            new ArrayList<>(),
            Status.ON_GOING);
    }

    boolean isLetterAlreadyPlayed(final String letter) {
        return guesses.contains(letter) || misses.contains(letter);
    }

    boolean isLetterInSecret(final String letter) {
        return word.contains(letter);
    }

    static String getGuessedWord(String secret, Set<String> letters) {
        return secret.chars()
            .mapToObj(i -> String.valueOf((char) i))
            .map(c -> letters.contains(c) ? c : "_")
            .collect(joining());
    }

    static boolean isWin(String secret, Set<String> guessedLetters) {
        return secret.chars()
            .mapToObj(i -> String.valueOf((char) i))
            .allMatch(guessedLetters::contains);
    }

    static boolean isLoss(List<Part> parts) {
        return parts.size() >= MAX_FAILURES;
    }

    @Override
    public String toString() {
        return "Output{" +
            "secret='" + word + '\'' +
            ", discovered='" + maskedWord + '\'' +
            ", guess=" + guesses +
            ", misses=" + misses +
            ", parts=" + parts +
            ", status=" + state +
            ", remainingFailures=" + remainingFailures +
            '}';
    }
}
