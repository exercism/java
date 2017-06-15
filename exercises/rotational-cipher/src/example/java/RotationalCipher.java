
public class RotationalCipher {

    public String rotate(String data, int shiftKey) {
        StringBuilder dataStringBuilder = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (Character.isUpperCase(c)) {
                dataStringBuilder.append(replacementCharacter(c, 'A', 'Z', shiftKey));
            } else if (Character.isLowerCase(c)) {
                dataStringBuilder.append(replacementCharacter(c, 'a', 'z', shiftKey));
            } else {
                dataStringBuilder.append(c);
            }
        }
        return dataStringBuilder.toString();
    }

    /**
     * 
     * @param characterToReplace
     * @param alphabetCaseStart
     * @param alphabetCaseEnd
     * @param shiftKey
     * @return ReplacementCharacter
     * 
     * For Uppercase CaseStart = 'A' and CaseEnd = 'Z'
     * For Lowercase CaseStart = 'a' and CaseEnd = 'z'
     */
    public char replacementCharacter(char characterToReplace,
            char alphabetCaseStart, char alphabetCaseEnd, int shiftKey) {
        char replacementCharacter = (char) (characterToReplace + shiftKey);
        if (replacementCharacter > alphabetCaseEnd) {
            replacementCharacter = (char) ((alphabetCaseStart - 1) +
             (replacementCharacter % alphabetCaseEnd));
        }
        return replacementCharacter;
    }
}
