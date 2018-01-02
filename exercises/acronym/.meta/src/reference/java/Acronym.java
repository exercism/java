import java.util.Arrays;
import java.util.stream.Collectors;

final class Acronym {

    private final String acronym;

    Acronym(String phrase) {
        acronym = generateAcronym(phrase);
    }

    String get() {
        return acronym;
    }

    private String generateAcronym(String phrase) {
        return Arrays.stream(phrase.split("[^a-zA-Z]"))
                .filter(word -> !word.isEmpty()) // Remove empty strings from the result of phrase.split
                .map(word -> word.substring(0, 1)) // Get the first character of each word
                .collect(Collectors.joining()) // Concatenate the characters
                .toUpperCase();
    }

}
