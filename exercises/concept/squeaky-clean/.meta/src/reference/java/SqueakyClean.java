class SqueakyClean {
    static String clean(String identifier) {
        final StringBuilder cleanIdentifier = new StringBuilder();
        boolean kebab = false;
        for (int i = 0; i < identifier.length(); i++) {
            final char ch = identifier.charAt(i);
            if (Character.isSpaceChar(ch) || Character.isDigit(ch)) {
                cleanIdentifier.append("_");
            } else if (ch == '-') {
                kebab = true;
            } else if (Character.isLetter(ch)) {
                cleanIdentifier.append(
                        kebab ? Character.toUpperCase(ch) : ch
                );
                kebab = false;
            }
        }
        return cleanIdentifier.toString();
    }
}
