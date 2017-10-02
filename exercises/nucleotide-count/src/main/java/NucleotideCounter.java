
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NucleotideCounter {
    private static final List<Character> DICT = Arrays.asList('T', 'A', 'G', 'C');
    private final int[] table;

    public NucleotideCounter(final String s) {
        this.table = new int[26];
        for (final char c : s.toUpperCase().toCharArray()) {
            this.table[c - 'A']++;
        }
    }

    public int count(final char c) {
        if (!DICT.contains(c)) {
            throw new IllegalArgumentException("Invalid DNA nucleotide!");
        }
        return this.table[Character.toUpperCase(c) - 'A'];
    }

    public Map<Character, Integer> nucleotideCounts() {
        final Map<Character, Integer> map = new HashMap<>();
        for (final char c : DICT) {
            map.put(c, this.table[c - 'A']);
        }
        return map;
    }

}
