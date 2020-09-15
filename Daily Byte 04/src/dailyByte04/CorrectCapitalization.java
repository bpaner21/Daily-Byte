package dailyByte04;

/*
 * 
 * Given a string, return whether or not it uses capitalization correctly. 
 * A string correctly uses capitalization if all letters are capitalized, 
 * no letters are capitalized, or only the first letter is capitalized.
 *
 * Ex: Given the following strings...
 * 
 * "USA", return true
 * "Calvin", return true
 * "compUter", return false
 * "coding", return true
 * 
 */

import java.util.Scanner;

public class CorrectCapitalization {

	static public void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please input a string: ");
		
		String str = scan.next();
		
		scan.close();
		
		if (correctCapitalization(str)) {
			System.out.println("\"" + str + "\" is correctly capitalized.");
		}
		else {
			System.out.println("\"" + str + "\" is not correctly capitalized.");
		}
		
		return;
	}
	
	static private Boolean correctCapitalization(String str) {
		
		if (str.length() <= 1) { return true; }
		
		int i = 0, j = str.length() - 1;
		
		if (Character.isLowerCase(str.charAt(i)) && Character.isUpperCase(str.charAt(j))) { 
			
			return false; 
			
		}
		
		if (Character.isUpperCase(str.charAt(i)) && Character.isUpperCase(str.charAt(j))) {

			++i;
			--j;
			
			while (i <= j) {
				
				if (Character.isLowerCase(str.charAt(i)) || Character.isLowerCase(str.charAt(j))) { 
					
					return false; 
					
				}
				
				++i;
				--j;
			}
			
		}
		else {
			
			++i;
			--j;
			
			while (i <= j) {
				
				if (Character.isUpperCase(str.charAt(i)) || Character.isUpperCase(str.charAt(j))) { 
					
					return false; 
					
				}
				
				++i;
				--j;
			}
		}
		
		return true;
	}
}
