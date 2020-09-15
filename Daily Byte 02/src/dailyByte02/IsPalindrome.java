package dailyByte02;

import java.util.*;

/*
 * Given a string, return whether or not it forms a 
 * palindrome ignoring case and non-alphabetical characters.
 * Note: A palindrome is a sequence of characters
 * that reads the same forwards or backwards.
 * 
 * Ex:
 * "level", return true
 * "algorithm", return false
 * "A man, a plan, a canal: Panama.", return true
 */
public class IsPalindrome {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please input a string to check: ");
		
		String str = scan.nextLine();
		
		scan.close();
		
		if (CheckPalindrome(str)) {
			System.out.println("\"" + str + "\" is a palindrome.");
		}
		else {
			System.out.println("\"" + str + "\" is not a palindrome.");
		}
	}
	
	private static boolean CheckPalindrome(String str) {
		
		int i = 0, j = str.length() - 1;
		
		char cI, cJ;
		
		while (i < j) {
			
			while (!Character.isLetter(str.charAt(i))) {
				
				++i;
			}
			
			while(!Character.isLetter(str.charAt(j))) {
				
				--j;
			}
			
			cI = Character.toLowerCase(str.charAt(i));
			cJ = Character.toLowerCase(str.charAt(j));
			
			if (cI != cJ) {
				return false;
			}
			
			++i;
			--j;
		}
		
		return true;
	}
}
