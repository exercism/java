import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym {

    private String acronym;

    Acronym(String phrase) {
        this.acronym = generateAcronym(phrase);
    }


    String get() {
        return acronym;
    }

    private String generateAcronym(String phrase) {
        String phraseWithoutUnderscores = phrase.replace("_", "");
        return Arrays.stream(phraseWithoutUnderscores.split("(?!')\\W"))
            .filter(word -> !word.isEmpty()) // Remove empty strings from the result of phrase.split
            .map(word -> word.substring(0, 1)) // Get the first character of each word
            .collect(Collectors.joining()) // Concatenate the characters
            .toUpperCase();
    }

}
