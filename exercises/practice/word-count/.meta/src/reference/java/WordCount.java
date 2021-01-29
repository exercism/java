import java.util.HashMap;
import java.util.Map;

class WordCount {

    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> countMap = new HashMap<>();
        input = input.trim().toLowerCase().replaceAll("([^A-Za-z0-9']|\\B'|'\\B)", " ");
        String[] tokenizedInput = input.split("\\s+");
        for (String aWord : tokenizedInput) {
            if (aWord.isEmpty()) {
                continue;
            }
            Integer count = countMap.get(aWord);
            countMap.put(aWord, count == null ? 1 : count + 1);
        }
        return countMap;
    }

}
