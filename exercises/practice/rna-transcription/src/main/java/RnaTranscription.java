//class RnaTranscription {
    
import java.util.*;
public class RnaTranscription {
    private static int nucleotideMap(int c){
        switch (c){
            case 'G' : return 'C';
            case 'C' : return 'G';
            case 'T' : return 'A';
            case 'A' : return 'U';
        }
        throw new IllegalArgumentException("Invalid input");
    }
    public String transcribe(String dnaStrand) {
        return dnaStrand
            .codePoints()
            .map(Character::toUpperCase)
            .map(RnaTranscription::nucleotideMap)
            .collect(StringBuilder::new,
                     StringBuilder::appendCodePoint,
                     StringBuilder::append)
            .toString();
    }
}

    /*
    String transcribe(String dnaStrand) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
    */

//}
