package dailyByte09;

/*
 * 
 * This question is asked by Amazon. 
 * Given a string representing your stones and another string representing a list of jewels, 
 * return the number of stones that you have that are also jewels.
 * 
 * Ex: Given the following jewels and stones...
 * 
 * jewels = "abc", stones = "ac", return 2
 * jewels = "Af", stones = "AaaddfFf", return 3
 * jewels = "AYOPD", stones = "ayopd", return 0
 * 
 */

import java.util.HashSet;

public class JewelsAndStones {

	public static void main(String[] args) {
		
		JSDriver("abc", "ac");
		JSDriver("Af", "AaaddfFf");
		JSDriver("AYOPD", "ayopd");
		
		return;
	}
	
	// Helper function to verify code using the example variables.
	private static void JSDriver(String jewels, String stones) {
		
		System.out.print("jewels = \"" + jewels + "\", stones = \"" + stones + "\", ");
		System.out.println  ("There are " + JewelCount(jewels, stones) + " jewels.");
	}
	
	private static int JewelCount(String jewels, String stones) {
		
		// The count of jewels in the stones
		int count = 0;
		
		HashSet<Character> jList = new HashSet<Character>();
		
		// Put all the unique characters in [jewels] into a hashset
		for (int i = 0; i < jewels.length(); ++i) {
			
			char c = jewels.charAt(i);
			
			if (!jList.contains(c)) {
				
				jList.add(c);
			}
		}
		
		// If a character in [stones] is in the hashset
		// increment the count of jewels in stones
		for (int j = 0; j < stones.length(); ++j) {
			
			if (jList.contains(stones.charAt(j))) {
				
				++count;
			}
		}
		
		return count;
	}
}
