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

    private static Output processNewLetter(
        final Output state,
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

    static final Part[] ORDER = Part.values();

}
