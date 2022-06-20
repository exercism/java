class SqueakyClean {
    static String clean(String identifier) {
        final StringBuilder cleanIdentifier = new StringBuilder();
        boolean kebab = false;
        for (int i = 0; i < identifier.length(); i++) {
            final char ch = identifier.charAt(i);
            if (Character.isSpaceChar(ch)) {
                cleanIdentifier.append("_");
            } else if (Character.isISOControl(ch)) {
                cleanIdentifier.append("CTRL");
            } else if (ch == '-') {
                kebab = true;
            } else if (isLetter(ch)) {
                cleanIdentifier.append(
                        kebab ? Character.toUpperCase(ch) : ch
                );
                kebab = false;
            }
        }
        return cleanIdentifier.toString();
    }
    private static boolean isLetter(char ch) {
        return Character.isLetter(ch) && !(ch >= 'α' && ch <= 'ω');
    }
}
