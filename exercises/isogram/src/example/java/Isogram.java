package exemple;

import java.util.HashSet;
import java.util.Set;

public class Isogram {
	
	public static boolean isIsogram(String word){
		
		Set<Character> charset= new HashSet<Character>();
		String[] words = word.split(" ");
		String newword = concat(words);
		words = newword.split("-");
		newword = concat(words).toLowerCase();
		
		for(int i = 0; i < newword.length(); i++)
			charset.add(newword.charAt(i));
		
		return charset.size() == newword.length();
	}
	
	public static String concat(String[] words){
		String newword = new String("");
		for(int i = 0; i < words.length; i++)
			newword = newword + words[i];
		return newword;
	}
	
}
