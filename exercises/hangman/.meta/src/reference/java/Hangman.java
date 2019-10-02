import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class Hangman {

    static Observable<Output> play(final Observable<String> words,
            final Observable<String> letters) {
        return words
                .flatMap(word -> {
                    return letters.scan(
                            new Output(
                                    word,
                                    IntStream.range(0, word.length()).mapToObj(i -> "_")
                                            .collect(joining()),
                                    new HashSet<>(),
                                    new HashSet<>(),
                                    new ArrayList<>(),
                                    Status.PLAYING),
                            Hangman::processNewLetter);
                });
    }

    private static Hangman.Output processNewLetter(final Hangman.Output state,
            final String letter) {
        if (state.guess.contains(letter) || state.misses.contains(letter)) {
            throw new IllegalArgumentException("Letter " + letter + " was already played");
        }
        if (state.secret.contains(letter)) {
            final Set<String> newGuess = new HashSet<>(state.guess);
            newGuess.add(letter);
            final String discovered = state.secret.chars()
                    .mapToObj(i -> String.valueOf((char) i))
                    .map(c -> newGuess.contains(c) ? c : "_")
                    .collect(joining());
            return new Output(
                    state.secret,
                    discovered,
                    newGuess,
                    state.misses,
                    state.parts,
                    discovered.contains("_") ? Status.PLAYING : Status.WIN);
        } else {
            final Set<String> newMisses = new HashSet<>(state.misses);
            newMisses.add(letter);
            final List<Part> newParts = new ArrayList<>(state.parts);
            final Status newStatus;
            if (newMisses.size() >= ORDER.length) {
                newStatus = Status.LOSS;
            } else {
                newParts.add(ORDER[newParts.size()]);
                newStatus = Status.PLAYING;
            }

            return new Output(
                    state.secret,
                    state.discovered,
                    state.guess,
                    newMisses,
                    newParts,
                    newStatus);
        }
    }

    static class Output {

        public final String secret;
        public final String discovered;
        public final Set<String> guess;
        public final Set<String> misses;
        public final List<Part> parts;
        public final Status status;

        Output(
                final String secret,
                final String discovered,
                final Set<String> guess,
                final Set<String> misses,
                final List<Part> parts,
                final Status status) {
            this.secret = secret;
            this.discovered = discovered;
            this.guess = guess;
            this.misses = misses;
            this.parts = parts;
            this.status = status;
        }
    }

    enum Status {
        PLAYING,
        WIN,
        LOSS
    }

    enum Part {
        HEAD,
        BODY,
        LEFT_ARM,
        RIGHT_ARM,
        LEFT_LEG,
        RIGHT_LEG
    }

    static final Part[] ORDER = Part.values();

}
