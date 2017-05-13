public class RnaTranscription {

    public String transcribe(String dnaStrand) {
        StringBuilder sb = new StringBuilder();
        for (char c : dnaStrand.toCharArray()) {
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
