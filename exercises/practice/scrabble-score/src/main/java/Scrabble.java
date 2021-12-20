import java.util.HashMap;
import java.util.Map;
class Scrabble {
    private String inputWord;
    private Map<Integer, String> letterMapping = new HashMap<>();
    Scrabble(String word) {
        this.inputWord = word;
        letterMapping.put(1, "A, E, I, O, U, L, N, R, S, T");
        letterMapping.put(2, "D, G");
        letterMapping.put(3, "B, C, M, P");
        letterMapping.put(4, "F, H, V, W, Y");
        letterMapping.put(5, "K");
        letterMapping.put(8, "J, X");
        letterMapping.put(10, "Q, Z");
    }
    int getScore() {
        final Integer[] letterScore={0};
        final Integer[] wordScore ={0};
        System.out.println("word=" + this.inputWord);
        for (char c : this.inputWord.toUpperCase().toCharArray()) {
            letterScore[0] = 0;
            letterMapping.forEach((key, value) -> {
                if (value.contains(String.valueOf(c)))
                    letterScore[0]+=key;
            });
           // System.out.println("letterScore=" + letterScore[0]);
            wordScore[0]+=letterScore[0];
        }
        System.out.println("wordScore=" + wordScore[0]);
        return wordScore[0];
    }
}
