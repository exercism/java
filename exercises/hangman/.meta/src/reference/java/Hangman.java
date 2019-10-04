import io.reactivex.Observable;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class Hangman {

    static Observable<Output> play(final Observable<String> words,
                                   final Observable<String> letters) {
        return Observable
            .combineLatest(
                words,
                letters.startWith(""),
                (word, letter) -> new AbstractMap.SimpleEntry<>(word, letter))
            .scan(
                new Output(
                    null,
                    null,
                    Collections.emptySet(),
                    Collections.emptySet(),
                    Collections.emptyList(),
                    null),
                (state, entry) -> {
                    System.out.println(state + " -> " + entry);
                    if (state == null || state.status != Status.PLAYING) {
                        return createNewGame(entry.getKey());
                    } else {
                        return processNewLetter(state, entry.getValue());
                    }
                })
            .skip(1); // Skip the initial state
    }

    private static Output createNewGame(String word) {
        return new Output(
            word,
            IntStream.range(0, word.length()).mapToObj(i -> "_")
                .collect(joining()),
            new HashSet<>(),
            new HashSet<>(),
            new ArrayList<>(),
            Status.PLAYING);
    }

    private static Hangman.Output processNewLetter(
        final Hangman.Output state,
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
            newParts.add(ORDER[newParts.size()]);
            final Status newStatus = newMisses.size() >= ORDER.length
                ? Status.LOSS
                : Status.PLAYING;

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

        @Override
        public String toString() {
            return "Output{" +
                "secret='" + secret + '\'' +
                ", discovered='" + discovered + '\'' +
                ", guess=" + guess +
                ", misses=" + misses +
                ", parts=" + parts +
                ", status=" + status +
                '}';
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
