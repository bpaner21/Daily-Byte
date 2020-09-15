package dailyByte07;

/*
 * 
 * Given a string and the ability to delete at most one character, 
 * return whether or not it can form a palindrome.
 * Note: a palindrome is a sequence of characters that reads the same forwards and backwards.
 * 
 * Ex: Given the following strings...
 * 
 * "abcba", return true
 * "foobof", return true (remove the first 'o', the second 'o', or 'b')
 * "abccab", return false
 * 
*/	


public class PalindromeWithRemoval {

	public static void main(String[] args) {
		
		String in1 = "abcba", in2 = "foobof", in3 = "abccab", in4 = "abecbea", in5 = "abcbea";
		
		System.out.println("\"" + in1 + "\": " + CanBePalindrome(in1));
		System.out.println("\"" + in2 + "\": " + CanBePalindrome(in2));
		System.out.println("\"" + in3 + "\": " + CanBePalindrome(in3));
		System.out.println("\"" + in4 + "\": " + CanBePalindrome(in4));
		System.out.println("\"" + in5 + "\": " + CanBePalindrome(in5));
		
		return;
	}
	
	private static Boolean CanBePalindrome(String str) {
		
		if (str.length() <= 1) { return true; }
		
		int i = 0, j = str.length() - 1;
		
		while (i < j) {
			
			if (str.charAt(i) == str.charAt(j)) {
				
				++i;
				--j;
			}
			else {
				
				if (IsPalindrome(str, i, j - 1)) { return true; }
				
				if (IsPalindrome(str, i + 1, j)) { return true; }
				
				return false;
			}
		}
		
		return true;
	}
	
	private static Boolean IsPalindrome(String str, int i, int j) {
		
		while (i < j) {
			
			if (str.charAt(i) != str.charAt(j)) { return false; }
			
			++i;
			--j;
		}
			
		
		return true;
	}
}
