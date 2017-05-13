public class RotationalCipher {
    public String rotate(String data, int  shiftKey){
        String cipherText = "";
        for(int i = 0;i < data.length(); i++){
            //for uppercase characters
            if(data.charAt(i) >= 'A' && data.charAt(i) <= 'Z'){
                char replacementCharacter = (char) (data.charAt(i) + shiftKey);
                if(replacementCharacter > 'Z'){
                    replacementCharacter = (char)(64 + (replacementCharacter % 90));
                }
                cipherText += replacementCharacter;
            }
            //for lowercase characters
            else if(data.charAt(i) >= 'a' && data.charAt(i) <= 'z'){
                char replacementCharacter = (char) (data.charAt(i) + shiftKey);
                if(replacementCharacter > 'z'){
                    replacementCharacter = (char)(96 + (replacementCharacter % 122));
                }
                cipherText += replacementCharacter;
            }
            //for other symbols
            else 
                cipherText += data.charAt(i);
            }
        return cipherText;
    }
}


