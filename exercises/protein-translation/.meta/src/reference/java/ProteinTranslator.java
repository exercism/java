import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ProteinTranslator {

    private static final String[] METHIONINE = {"AUG"};
    private static final String[] PHENYLALANINE = {"UUU", "UUC"};
    private static final String[] LEUCINE = {"UUA", "UUG"};
    private static final String[] SERINE = {"UCU", "UCC", "UCA", "UCG"};
    private static final String[] TYROSINE = {"UAU", "UAC"};
    private static final String[] CYSTEINE = {"UGU", "UGC"};
    private static final String[] TRYPTOPHAN = {"UGG"};
    private static final String[] STOP = {"UAA", "UAG", "UGA"};

    List<String> translate(String rnaSequence) {

        List<String> proteinList = new ArrayList<String>();

        for (int i = 0; i < rnaSequence.length(); i += 3) {
            String codon = rnaSequence.substring(i, i + 3);

            if (Arrays.asList(METHIONINE).contains(codon)) {
                proteinList.add("Methionine");
            } else if (Arrays.asList(PHENYLALANINE).contains(codon)) {
                proteinList.add("Phenylalanine");
            } else if (Arrays.asList(LEUCINE).contains(codon)) {
                proteinList.add("Leucine");
            } else if (Arrays.asList(SERINE).contains(codon)) {
                proteinList.add("Serine");
            } else if (Arrays.asList(TYROSINE).contains(codon)) {
                proteinList.add("Tyrosine");
            } else if (Arrays.asList(CYSTEINE).contains(codon)) {
                proteinList.add("Cysteine");
            } else if (Arrays.asList(TRYPTOPHAN).contains(codon)) {
                proteinList.add("Tryptophan");
            } else if (Arrays.asList(STOP).contains(codon)) {
                break;
            } else {
                throw new IllegalArgumentException("Invalid input");
            }

        }

        return proteinList;
    }
}
