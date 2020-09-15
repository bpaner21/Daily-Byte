package dailyByte05;

/*
 * 
 * Given two binary strings (strings containing only 1s and 0s) return their sum (also as a binary string).
 * Note: neither binary string will contain leading 0s unless the string itself is 0
 *
 * Ex: Given the following binary strings...
 * 
 * "100" + "1", return "101"
 * "11" + "1", return "100"
 * "1" + "0", return  "1"
 * 
 */

import java.util.Scanner;

public class AddBinary {
	
	public static void main(String args[]) {
	
		Scanner scan = new Scanner(System.in);
	
		System.out.println("Please input 2 binary strings to add: ");
	
		String x = scan.next(), y = scan.next(); 
		
		scan.close();
		
		System.out.println(x + " + " + y + " = " + BinaryAdd(x, y)); 
	}
	
	private static String BinaryAdd(String a, String b) {
		
		String c = "";
		
		int x = a.length() - 1, y = b.length() - 1;
		
		int ones = 0;
		
		while (x >= 0 || y >= 0 || ones == 1) {
			
			// is digit x for string a '1'
			ones += (x >= 0 && a.charAt(x) == '1') ? 1 : 0; 
			
			// is digit y for string b '1'
			ones += (y >= 0 && b.charAt(y) == '1') ? 1 : 0; 
			
			// is the sum of digits '0' or '1'
			if (ones % 2 == 1) {
				
				c = '1' + c;
			}
			else {
				
				c = '0' + c;
			}
			
			// is there a digit carried over or not
			ones /= 2;
			
			--x;
			--y;
		}
		
		return c;
	}

}
