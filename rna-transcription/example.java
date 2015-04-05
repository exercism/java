public class RnaTranscription {

    public static String ofDna(String strand) {
        StringBuilder sb = new StringBuilder();
        for (char c : strand.toCharArray()) {
            switch (c) {
            case 'A':
                sb.append('U');
                break;
            case 'G':
                sb.append('C');
                break;
            case 'C':
                sb.append('G');
                break;
            case 'T':
                sb.append('A');
                break;
            }
        }
        return sb.toString();
    }
}
