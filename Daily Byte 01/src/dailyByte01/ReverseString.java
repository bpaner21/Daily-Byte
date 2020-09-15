package dailyByte01;

import java.util.Scanner;

public class ReverseString {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a string to be reversed: ");
		
		String str = scan.nextLine();
		
		scan.close();
		
		String rStr = Reverse(str);
		
		System.out.println("The reverse of " + str + " is " + rStr + ".");
	}
	
	private static String Reverse(String str) {
		
		char[] cA = str.toCharArray();
		int i = 0, j = str.length() - 1;
		char temp;
		
		while (i < j) {
			
			temp = cA[i];
			cA[i] = cA[j];
			cA[j] = temp;
			
			++i;
			--j;
		}
		
		return new String(cA);
	}
}
