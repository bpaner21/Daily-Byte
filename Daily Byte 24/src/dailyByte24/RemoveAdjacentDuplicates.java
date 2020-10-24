package dailyByte24;

/*
 * This question is asked by Facebook. 
 * Given a string s containing only lowercase letters, 
 * continuously remove adjacent characters that are the same and return the result.
 * 
 * Ex: Given the following strings...
 * 
 * s = "abccba", return ""
 * s = "foobar", return "fbar"
 * s = "abccbefggfe", return "a"
 */

public class RemoveAdjacentDuplicates {

	public static void main(String[] args) {
		
		rADDriver("abccba");
		rADDriver("foobar");
		rADDriver("abccbefggfe");
		System.out.println();
		rADDriver("bookkeeper");
		
		return;
	}
	
	public static void rADDriver(String s) {
		
		System.out.println("s = \"" + s + "\", return \"" + removeAdjacentDuplicates(s) + "\"");
		
		return;
	}
	
	public static String removeAdjacentDuplicates(String s) {
		
		StringBuilder sB = new StringBuilder();
		
		for (char c : s.toCharArray()) {
			
			//System.out.println(sB.length());
			
			int curSize = sB.length();
			
			if (curSize > 0 && sB.charAt(curSize - 1) == c) {
				
				sB.deleteCharAt(curSize - 1);
			}
			else {
				
				sB.append(c);
			}
			
		}
		
		return sB.toString();
	}
}
