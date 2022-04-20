import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

class Dna{
    protected String nucleotide = "";
    public Dna(char nucleotide){
        this.nucleotide = Character.toString(nucleotide);
    }
    public Dna(String nucleotide){
        this.nucleotide = nucleotide;
    }
    public String getNucleotide(){
        return this.nucleotide;
    }
}

class Rna{
    protected String nucleotide = "";

    public Rna(Dna dna){
        String temp = "";
        switch(dna.getNucleotide()){
            case "G":
                temp = "C";
                break;
            case "C":
                temp = "G";
                break;
            case "T":
                temp = "A";
                break;
            case "A":
                temp = "U";
                break;
            }
        this.nucleotide = temp;
    }
    public String getNucleotide(){
        return this.nucleotide;
    }
}
class RnaTranscription {
    String transcribe(String dnaStrand){
        List<String> dnaStrand_ = new Vector<String>();

        for(String s : dnaStrand.split(""))
            dnaStrand_.add(s);

        List<String> rna = dnaStrand_.stream()
            .map( nucleotide -> new Dna(nucleotide) )
            .map( dna -> new Rna(dna) )
            .map( rna_ -> rna_.getNucleotide() )
            .collect(Collectors.toList());

        return String.join("", rna);
    }
}
