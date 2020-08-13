class Identifier {
    static String clean(String identifier) {
        final StringBuilder cleanIdentifier = new StringBuilder();
        for (int i = 0; i < identifier.length(); i++) {
            final char ch = identifier.charAt(i);
            if (Character.isSpaceChar(ch)) {
                cleanIdentifier.append("_");
            } else if (Character.isISOControl(ch)) {
                cleanIdentifier.append("CTRL");
            } else if (ch == '-' && i < identifier.length() + 1) {
                i++;
                cleanIdentifier.append(Character.toUpperCase(identifier.charAt(i)));
            } else if (ch >= 'α' && ch <= 'ω') {
            } else if (Character.isAlphabetic(ch)) {
                cleanIdentifier.append(ch);
            }
        }
        return cleanIdentifier.toString();
    }
}
