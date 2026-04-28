import java.util.List;
import java.util.Set;

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

}
