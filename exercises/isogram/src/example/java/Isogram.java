package main;

import java.util.HashSet;
import java.util.Set;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class Isogram {
	
	public static boolean isIsogram(String word){
		
		Set<Character> charset = new HashSet<>();
		
		String[] words = word.split(" ");
		String newWord = concat(words);
		
		words = newWord.split("-");
		newWord = concat(words).toLowerCase();
		
		for(int i = 0; i < newWord.length(); i++){
			charset.add(newWord.charAt(i));
		}
		
		return charset.size() == newWord.length();
	}
	
	public static String concat(String[] words){
		return stream(words).collect(joining());
	}
	
}
