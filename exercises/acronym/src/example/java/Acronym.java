import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Acronym {
    public static String generate(String phrase){
        final Pattern BREAK_WORDS = Pattern.compile("[A-Z]+[a-z]*|[a-z]+");
        final Matcher matcher = BREAK_WORDS.matcher(phrase);
        final StringBuilder b = new StringBuilder();
        while (matcher.find()){
            b.append(matcher.group().charAt(0));
        }
        return b.toString().toUpperCase();
    }
}