final class Proverb {
    private String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        if (words.length < 1) return "";
        String initWord = "",
               result   = "";
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if (initWord.isEmpty()) {
                initWord = word;
            } else {
                result += "the " + word + " was lost.\n";
            }
            if (i + 1 != words.length) result += "For want of a " + word + " ";
        }
        return result += "And all for the want of a " + initWord + ".";
    }
}
