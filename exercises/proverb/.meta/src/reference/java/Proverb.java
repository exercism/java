final class Proverb {
    private String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        if (words.length < 1) return "";
        final StringBuilder result = new StringBuilder();
        for(int i = 1; i < words.length; i++) {
            if (i != words.length) {
                result.append("For want of a " + words[i - 1] + " ");
            }
            result.append("the " + words[i] + " was lost.\n");
        }
        result.append("And all for the want of a " + words[0] + ".");
        return result.toString();
    }
}
