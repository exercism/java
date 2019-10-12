import io.reactivex.Observable;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class Hangman {

    Observable<Output> play(
            Observable<String> words,
            Observable<String> letters) {
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
            Output state,
            String letter) {
        if (state.guess.contains(letter) || state.misses.contains(letter)) {
            throw new IllegalArgumentException("Letter " + letter + " was already played");
        }
        if (state.secret.contains(letter)) {
            Set<String> newGuess = new HashSet<>(state.guess);
            newGuess.add(letter);
            String discovered = state.secret.chars()
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
            Set<String> newMisses = new HashSet<>(state.misses);
            newMisses.add(letter);
            List<Part> newParts = new ArrayList<>(state.parts);
            newParts.add(order[newParts.size()]);
            Status newStatus = newMisses.size() >= order.length
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

    static Part[] order = Part.values();

}
