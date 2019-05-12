class FoodChain {

    private static final String[] ANIMALS = {
        "fly",
        "spider",
        "bird",
        "cat",
        "dog",
        "goat",
        "cow"
    };

    private static final String[] FOLLOWUPS = {
        "It wriggled and jiggled and tickled inside her.",
        "How absurd to swallow a bird!",
        "Imagine that, to swallow a cat!",
        "What a hog, to swallow a dog!",
        "Just opened her throat and swallowed a goat!",
        "I don't know how she swallowed a cow!"
    };

    String verse(int verse) {
        return verseBeginning(verse) + verseMiddle(verse) + verseEnding(verse);
    }

    String verses(int startVerse, int endVerse) {

        String[] verses = new String[endVerse - startVerse + 1];

        for (int i = 0; i <= endVerse - startVerse; i++) {
            verses[i] = verse(i + 1);
        }

        return String.join("\n\n", verses);
    }

    private String verseBeginning(int verse) {

        if (verse == 1) {
            return "I know an old lady who swallowed a fly.\n";
        }

        if (verse == 8) {
            return "I know an old lady who swallowed a horse.\n";
        }

        return "I know an old lady who swallowed a " + ANIMALS[verse - 1] + ".\n" + FOLLOWUPS[verse - 2] + "\n";
    }

    private String verseMiddle(int verse) {

        if (verse == 1 || verse == 8) {
            return "";
        }

        String[] lines = new String[verse - 1];

        for (int i = verse - 1; i >= 1; i--) {
            lines[lines.length - i] = "She swallowed the " +
                    ANIMALS[i] + " to catch the " + ANIMALS[i - 1] +
                    (i == 2 ? " that wriggled and jiggled and tickled inside her." : ".");
        }

        return String.join("\n", lines) + "\n";
    }

    private String verseEnding(int verse) {

        if (verse == 8) {
            return "She's dead, of course!";
        }

        return "I don't know why she swallowed the fly. Perhaps she'll die.";
    }
}
