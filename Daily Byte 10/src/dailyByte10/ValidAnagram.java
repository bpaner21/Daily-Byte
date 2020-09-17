package dailyByte10;

import java.util.Arrays;

/*
 * This question is asked by Facebook. 
 * Given two strings s and t return whether or not s is an anagram of t.
 * Note: An anagram is a word formed by reordering the letters of another word.
 * 
 * Ex: Given the following strings...
 * 
 * s = "cat", t = "tac", return true
 * s = "listen", t = "silent", return true
 * s = "program", t = "function", return false
 * 
 */

public class ValidAnagram {

	public static void main(String[] args) {
		
		VADriver("cat", "tac");
		VADriver("CAT", "tac");
		VADriver("listen", "silent");
		VADriver("program", "function");
		VADriver("mississippi", "alabama");
		VADriver("NORMAL", "lorman");
		
		return;
	}
	
	// Helper function to validate program using example variables
	private static void VADriver(String s, String t) {
		
		System.out.println("s = \"" + s + "\", t = \"" + t + "\": " + isAnagram(s,t));
		
		return;
	}
	
	private static Boolean isAnagram(String s, String t) {
		
		// If either string is null or empty, return false
		if (!ValidString(s) || !ValidString(t)) { return false; }
		
		// If string lengths differ, they cannot be anagrams
		if (s.length() != t.length()) { return false; }
		
		// Optional conversion to lower case
		// if case-sensitivity is not a concern
		// s = s.toLowerCase();
		// t = t.toLowerCase();
		
		// Convert both strings to char arrays and sort
		char[] sA = s.toCharArray(), tA = t.toCharArray();
		
		Arrays.sort(sA);
		Arrays.sort(tA);
		
		// If the sorted arrays differ from one another
		// the original strings are not anagrams
		for (int i = 0; i < s.length(); ++i) {
			
			if (sA[i] != tA[i]) { return false; }
		}
		
		return true;
	}
	
	private static Boolean ValidString(String s) {
		
		return (s != null && s != "");
	}
}
