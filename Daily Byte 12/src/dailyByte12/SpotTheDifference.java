package dailyByte12;

import java.util.Arrays;

/*
 * This question is asked by Google. 
 * You are given two strings, s and t which only consist of lowercase letters. 
 * t is generated by shuffling the letters in s as well as potentially adding an additional random character. 
 * Return the letter that was randomly added to t if it exists, otherwise, return � �.
 * Note: You may assume that at most one additional character can be added to t.
 *
 * Ex: Given the following strings...
 * 
 * s = "foobar", t = "barfoot", return 't'
 * s = "ide", t = "idea", return 'a'
 * s = "coding", t "ingcod", return ''
 * 
 */

public class SpotTheDifference {

	public static void main(String[] args) {
		
		SDDriver("foobar", "barfoot");
		SDDriver("ide", "idea");
		SDDriver("coding", "ingcod");
		
		return;
	}
	
	private static void SDDriver(String s, String t) {
		
		System.out.println("\"" + s + "\", \"" + t + "\": '" + SpotDif(s, t) + "'");
	}
	
	private static char SpotDif(String s, String t) {
		
		char c = 0;
		
		if (s.length() == t.length()) { return c; }
		
		for (int i = 0; i < s.length(); ++i) {
			
			c -= s.charAt(i);
		}
		
		for (int j = 0; j < t.length(); ++j) {
			
			c += t.charAt(j);
		}
		
		return c;
	}
}
