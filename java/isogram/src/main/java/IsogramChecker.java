import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        phrase = phrase.toLowerCase();
        Set<Integer> seen = new HashSet<>();

        for (Integer cp : phrase.codePoints().toArray()) {
            if (seen.contains(cp) && Character.isAlphabetic(cp)) {
                return false;
            }
            seen.add(cp);
        }

        return true;
    }

}
