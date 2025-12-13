class SqueakyClean {
    static String clean(String identifier) {
     //   throw new UnsupportedOperationException("Please implement the (static) SqueakyClean.clean() method");
        int index =0;
        String cleanString = identifier.replace(' ','_');
        if(cleanString.contains("-")) {
            index = cleanString.indexOf('-');
            cleanString = cleanString.replace("-", "");
            cleanString = cleanString.substring(0,index) + cleanString.substring(index,index+1).toUpperCase() + cleanString.substring(index+1);
        }
        char[] chars = cleanString.toCharArray();
        String newString = "";
        for(char c : chars) {
            if(c=='4') c = 'a';
            else if(c=='3') c = 'e';
            else if(c=='0') c = 'o';
            else if(c=='1') c = 'l';
            else if(c=='7') c = 't';

            newString += c;
        }
        cleanString = newString;

        chars = cleanString.toCharArray();
        newString = "";
        for(char c : chars) {
            if(Character.isAlphabetic(c)) newString += c;
            else if(c=='_') newString += c;
        }
        cleanString = newString;


        return cleanString;
    }
}
