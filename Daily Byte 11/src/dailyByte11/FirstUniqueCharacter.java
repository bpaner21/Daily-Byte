package dailyByte11;

import java.util.Map;
import java.util.HashMap;

/*
 * This question is asked by Microsoft. 
 * Given a string, return the index of its first unique character. 
 * If a unique character does not exist, return -1.
 * 
 * Ex: Given the following strings...
 * 
 * "abcabd", return 2
 * "thedailybyte", return 1
 * "developer", return 0
 */

/*
 * Assuming that this function does not require case-sensitivity,
 * and that all entries only include lower case letters.
 */

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		
		FirstUCharDriver("abcabd");
		FirstUCharDriver("thedailybyte");
		FirstUCharDriver("developer");
		
		FirstUCharDriver("alfalfa");
		FirstUCharDriver("a");
		FirstUCharDriver("microsoft");
		FirstUCharDriver("google");
		
		return;
	}
	
	// Driver code to validate function with example variables
	private static void FirstUCharDriver(String str) {
		
		int uCharIndex = FirstUniqueChar(str);
		
		if (uCharIndex != -1) {
			System.out.println("\"" + str + "\": " +  uCharIndex);
		}
		else {
			System.out.println("\"" + str + "\" has no unique characters.");
		}
		
		return;
	}
	
	// Find the first unique character in a string (if it exists)
	// in at most O(2N) time, where N is the number of characters
	// in the string.
	// Can be made case-sensitive
	private static int FirstUniqueChar(String str) {
		
		// Validate string
		if (str == null || str == "") { return -1; }
		
		// If string is only 1 character long, 
		// it is a unique character in itself. 
		if (str.length() == 1) { return 0; }
		
		HashMap<Character, Integer> charCount = new HashMap<>();
		
		// 
		for (int i = 0; i < str.length(); ++i) {
			
			char c = str.charAt(i);
			
			charCount.merge(c, 1, Integer::sum);
		}
		
		for (int j = 0; j < str.length(); ++j) {
			
			char c = str.charAt(j);
			
			if (charCount.get(c) == 1) { return j; }
		}
		
		return -1;
	}
}
