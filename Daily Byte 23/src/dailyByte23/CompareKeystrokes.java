package dailyByte23;

/*
 * This question is asked by Amazon. 
 * Given two strings s and t, which represents a sequence of keystrokes, 
 * where # denotes a backspace, return whether or not the sequences produce the same result.
 * 
 * Ex: Given the following strings...
 * 
 * s = "ABC#", t = "CD##AB", return true
 * s = "como#pur#ter", t = "computer", return true
 * s = "cof#dim#ng", t = "code", return false
 */

import java.util.Stack;

public class CompareKeystrokes {

	public static void main(String[] args) {
		
		CKDriver("ABC#", "CD##AB");
		CKDriver("como#pur#ter", "computer");
		CKDriver("cof#dim#ng", "code");
		
		return;
	}
	
	public static void CKDriver(String s, String t) {
		
		System.out.println("\"" + s + "\", " + t + "\", " + compareKeystrokes(s, t));
	}
	
	private static boolean compareKeystrokes(String s, String t) {
		
		int sPtr = s.length() - 1, tPtr = t.length() - 1, backSpace;
		
		while (true) {
			
			// The current number of backspaces in the string
			backSpace = 0;
			
			// Iterating backwards from the last character of s,
			// While you need to continue moving back (back > 0)
			while (sPtr >= 0 && (backSpace > 0 || s.charAt(sPtr) == '#')) {
				
				// Or the current character of s is '#',
				// in which case you need to move back one extra space
				backSpace = (s.charAt(sPtr) == '#') ? ++backSpace : --backSpace;
				
				// Continue decrementing sPtr
				--sPtr;
			}
			
			//	//	//	//	//
			
			backSpace = 0;
			
			// Repeat the above loop for t
			while (tPtr >= 0 && (backSpace > 0 || t.charAt(tPtr) == '#')) {
				
				backSpace = (t.charAt(tPtr) == '#') ? ++backSpace : --backSpace;
				--tPtr;
			}
			
			//	//	//	//	//
			
			// if the current characters of s and t match, continue the loop
			if (sPtr >= 0 && tPtr >= 0 && s.charAt(sPtr) == t.charAt(tPtr)) { 
				
				--sPtr; 
				--tPtr; 
			}
			
			// Otherwise check that you have completely validated both strings
			else { 
				
				return (sPtr == -1 && tPtr == -1); 
			}  
		}
	}
}
