import java.lang.Integer;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public Map<String, Integer> phrase( String input ) {
        Map<String, Integer> countMap = new HashMap<>();
        input = input.trim().toLowerCase().replaceAll("([^A-Za-z0-9']|\\B'|'\\B)", " ");
        final String[] tokenizedInput = input.split("\\s+");
        for( String aWord : tokenizedInput ) {
            Integer count = countMap.get(aWord);
            countMap.put(aWord, count == null ? 1 : count + 1 );
        }
        return countMap;
    }

}
