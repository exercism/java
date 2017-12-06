final class Proverb {
    private String[] words;
    private String initWord, result;


    public Proverb(String... words) {
        this.words = words;
    }

    public String getProverb() {
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if (initWord == null) {
                initWord = word;
                result = "For want of a " + word + " ";
            } else {
                result += "the " + word + " was lost.\n";
                if (i + 1 != words.length) result += "For want of a " + word + " ";
            }
        }
        result += "And all for the want of a " + initWord + ".";
        return result;
    }
}
