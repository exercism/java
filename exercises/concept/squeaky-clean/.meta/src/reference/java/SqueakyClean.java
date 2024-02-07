class SqueakyClean {

    private static char replaceDigit(char digit) {
        if (digit == '3') {
            return 'e';
        }

        if (digit == '4') {
            return 'a';
        }

        if (digit == '0') {
            return 'o';
        }

        if (digit == '1') {
            return 'l';
        }
        return 't';
    }

    static String clean(String identifier) {
        final StringBuilder cleanIdentifier = new StringBuilder();
        boolean kebab = false;
        for (int i = 0; i < identifier.length(); i++) {
            final char ch = identifier.charAt(i);
            if (Character.isWhitespace(ch)) {
                cleanIdentifier.append("_");
            } else if (Character.isDigit(ch)) {
                cleanIdentifier.append(SqueakyClean.replaceDigit(ch));
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
