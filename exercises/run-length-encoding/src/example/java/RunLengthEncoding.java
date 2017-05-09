import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunLengthEncoding {
    public String encode(String data) {
    	String encodedData = "";

    	for(int i = 0; i < data.length(); i++) {
    		char c = data.charAt(i);

    		if(i != 0 && c == data.charAt(i - 1)) continue;

    		int amt = 1;

    		for(int j = i+1; j < data.length() && c == data.charAt(j); j++) {
    			amt++;
    		}

    		if(amt == 1) encodedData += c;
    		else encodedData += amt + Character.toString(c);
    	}

    	return encodedData;
    }

    public String decode(String encodedData) {
    	String decodedData = "";
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z\s]");
        Matcher matcher = pattern.matcher(encodedData);

        while (matcher.find()) {
        	try {
	            int number = Integer.parseInt(matcher.group());
	        
	            matcher.find();
	        
	            while (number-- != 0) {
	                decodedData += matcher.group();
	            }
        	} catch(NumberFormatException e) {
        		decodedData+=matcher.group();
        	}
        }

        return decodedData;
    }
}