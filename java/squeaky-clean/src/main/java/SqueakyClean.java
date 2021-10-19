class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder clean = new StringBuilder();

        for (int i = 0; i < identifier.length(); i++) {
            char ch = identifier.charAt(i);

            if (ch >= 'α' && ch <= 'ω') {
                continue;
            }

            if (ch == '-' && i < identifier.length() - 1) {
                char next = identifier.charAt(i + 1);
                char nextUpper = Character.toUpperCase(next);
                clean.append(nextUpper);
                i++;
                continue;
            }

            if (Character.isSpaceChar(ch)) {
                clean.append("_");
            } else if (Character.isISOControl(ch)) {
                clean.append("CTRL");
            } else if (Character.isAlphabetic(ch)) {
                clean.append(ch);
            }
        }

        return clean.toString();
    }
}
