class RotationalCipher {

    private int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        StringBuilder dataStringBuilder = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (Character.isUpperCase(c)) {
                dataStringBuilder.append(getReplacementCharacter(c, 'A', 'Z'));
            } else if (Character.isLowerCase(c)) {
                dataStringBuilder.append(getReplacementCharacter(c, 'a', 'z'));
            } else {
                dataStringBuilder.append(c);
            }
        }
        return dataStringBuilder.toString();
    }

    /**
     * For Uppercase CaseStart = 'A' and CaseEnd = 'Z'
     * For Lowercase CaseStart = 'a' and CaseEnd = 'z'
     */
    private char getReplacementCharacter(char characterToReplace, char alphabetCaseStart, char alphabetCaseEnd) {
        char replacementCharacter = (char) (characterToReplace + shiftKey);
        if (replacementCharacter > alphabetCaseEnd) {
            replacementCharacter = (char) ((alphabetCaseStart - 1) + (replacementCharacter % alphabetCaseEnd));
        }
        return replacementCharacter;
    }
}
