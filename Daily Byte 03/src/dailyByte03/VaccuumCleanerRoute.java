package dailyByte03;

/*
 * 
 * Given a string representing the sequence of moves a vacuum cleaner makes,
 * return whether or not it will return to its original position.
 * The string will only contain 'L', 'R', 'U', and 'D' characters,
 * representing left, right, up, and down, respectively.
 * 
 * EX:
 * "LR" will return true
 * "URURD" will return false
 * "RUULLDRD" will return true
 * 
 */

import java.util.Scanner;

public class VaccuumCleanerRoute {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please input the vacuum cleaner's route: ");
		
		String str = scan.next();
		
		scan.close();
		
		if (validateRoute(str)) {
			
			System.out.println("\"" + str + "\" will return the vacuum to its original position." );
		}
		else {
			System.out.println("\"" + str + "\" will not return the vacuum to its original position." );
		}
		
	}
	
	private static boolean validateRoute(String str) {
		
		// A route with an odd number of moves will never return 
		// the vacuum to its original position
		if (str.length() % 2 == 1) { return false; }
		
		int i = 0, j = str.length() - 1;
		
		// a 2-integer array to record the number of left and right,
		// and up and down movements of the vacuum
		int[] path = new int[] {0, 0};
		
		while (i < j) {
			
			// increment the appropriate indices of path[] for left and up movements
			// decrement for right and down movements
			path = LRUD(str.charAt(i), path);
			path = LRUD(str.charAt(j), path);
			
			++i;
			--j;
		}
		
		// A closed path must have an equal number of left and right,
		// as well as up and down movements, which will leave
		// both indices of path[] at 0.
		// Any other values means that the path is not closed, 
		// and that the vacuum has not returned to its original position.
		return (path[0] == 0 && path[1] == 0);
	}
	
	private static int[] LRUD(char c, int[] path) {
		
		switch(c) {
		
		case 'L':
			++path[0];
			break;
		case 'R':
			--path[0];
			break;
		case 'U':
			++path[1];
			break;
		case 'D':
			--path[1];
			break;
		}
		
		return path;
	}
}
