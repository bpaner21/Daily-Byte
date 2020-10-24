package dailyByte22;

/*
 * This question is asked by Google. 
 * Given a string only containing the following characters 
 * (, ), {, }, [, and ] 
 * return whether or not the opening and closing characters are in a valid order.
 * 
 * Ex: Given the following strings...
 * 
 * "(){}[]", return true
 * "(({[]}))", return true
 * "{(})", return false
 */

import java.util.Stack;

public class ValidateCharacters {

	public static void main(String[] args) {
		
		vCDriver("(){}[]");
		vCDriver("(({[]}))");
		vCDriver("{(})");
		
		return;
	}
	
	public static void vCDriver(String str) {

		System.out.println("\"" + str + "\", " + validCharacters(str));
		
		return;
	}
	
	// Linear-time function to validate 
	// bracket pairs in a string
	public static boolean validCharacters(String str) {
		
		Stack<Character> chStack = new Stack<>();
		
		for (char c : str.toCharArray()) {
			
			switch(c) {
			
				// If c is a left bracket,
				// push its partner onto the stack
				case '(':
					chStack.push(')');
					break;
					
				case '{':
					chStack.push('}');
					break;
					
				case '[':
					chStack.push(']');
					break;
					
				// If c is a right bracket, pop the stack
				// and see if the characters match
				// 
				// If the stack is empty, 
				// automatically return false
				default:
					if (chStack.isEmpty() || c != chStack.pop()) { return false; }
					break;
			}
		}
		
		return chStack.isEmpty();
	}
}
