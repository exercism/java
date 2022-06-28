class RnaTranscription {

    String transcribe(String dnaStrand) {
        String rnaStrand="";
        for(int i=0;i<dnaStrand.length();i++){
            if(dnaStrand.charAt(i)=='G')
                rnaStrand+='C';
            else if(dnaStrand.charAt(i)=='C')
                rnaStrand+='G';
            else if(dnaStrand.charAt(i)=='T')
                rnaStrand+='A';
            else
                rnaStrand+='U';
        }
        return rnaStrand;
       
    }

}
