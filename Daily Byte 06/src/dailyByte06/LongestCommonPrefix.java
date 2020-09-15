package dailyByte06;

/*
 * Given an array of strings, return the longest common prefix that is shared amongst all strings.
 * Note: you may assume all strings only contain lowercase alphabetical characters.
 *
 * Ex: Given the following arrays...
 *
 * ["colorado", "color", "cold"], return "col"
 * ["a", "b", "c"], return ""
 * ["spot", "spotty", "spotted"], return "spot"
 *
 */


public class LongestCommonPrefix {

	public static void main(String[] args) {
		
		String input[] = new String[]{
				
				"spot", "spotty", "spotted"
		};
		
		System.out.println("The longest common prefix is \"" + LCP(input) + "\".");
		
		return;
	}
	
	private static String LCP (String[] arr) {
		
		if (arr == null || arr.length == 0) { return ""; } 
		
		if (arr.length == 1) { return arr[0]; }
		
		for (int i = 0; i < arr[0].length(); ++i) {
			
			char c = arr[0].charAt(i);
			
			for (int j = 1; j < arr.length; ++j) {
				
				if (i == arr[j].length() || arr[j].charAt(i) != c) {
					
					return arr[0].substring(0, i);
				}
			}
		}
		
		return arr[0];
	}
}
