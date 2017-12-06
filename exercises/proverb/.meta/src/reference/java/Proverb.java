final class Proverb {
    private String[] words;
    private String initWord, qualifier, result = "";


    public Proverb(String... words) {
        this.words = words;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getProverb() {
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if (initWord == null) {
                initWord = word;
            } else {
                result += "the " + word + " was lost.\n";
            }
            if (i + 1 != words.length) result += "For want of a " + word + " ";
        }
        result += "And all for the want of a ";
        result += (qualifier == null) ? initWord : qualifier + " " + initWord;
        return result += ".";
    }
}
