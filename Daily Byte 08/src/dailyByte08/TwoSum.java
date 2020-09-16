package dailyByte08;

/*
 * 
 * This question is asked by Google. 
 * Given an array of integers, return whether or not 
 * two numbers sum to a given target, k.
 * Note: you may not sum a number with itself.
 * 
 * Ex: Given the following...
 * 
 * [1, 3, 8, 2], k = 10, return true (8 + 2)
 * [3, 9, 13, 7], k = 8, return false
 * [4, 2, 6, 5, 2], k = 4, return true (2 + 2)
 * 
 */

import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;

public class TwoSum {
	
	public static void main (String[] args) {
		
		Random r = new Random();
		
		int lowerBound = 0;
		int upperBound = 20;
		
		for (int i = 0; i < 5; ++i) {
			
			// k is a random value between 1 and (2 * upperBound)
			int k = r.nextInt(upperBound * 2) + 1;
			
			System.out.print("k = " + k + ", ");
				
			// Generate an array arr randomly containing elements
			// between a lower and upper bound
			ArrayList<Integer> arr = GenerateRandomArray(lowerBound, upperBound, k);
			
			// Check if arr contains a two-integer sum for k
			System.out.println(HasTwoSum(arr, k));
		}
		
		return;
	}
	
	static private ArrayList<Integer> GenerateRandomArray(int lowerBound, int upperBound, int k) {
		
		Random r = new Random(System.currentTimeMillis() + k);
		
		int arrSize = r.nextInt(upperBound - lowerBound) + lowerBound + 1;
		
		//System.out.println("arrSize: " + arrSize + "\nk: " + k);
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		System.out.print("arr = [");
		
		int x = r.nextInt(upperBound) + 1;
		
		arr.add(x);
		
		System.out.print(x);
		
		for (int i = 0; i < arrSize - 1; ++i) {
			
			while(arr.contains(x)) {
			
				x = r.nextInt(upperBound) + 1;
			}
			
			arr.add(x);
			
			System.out.print(", " + x);
		}
		
		System.out.print("]: ");
		
		return arr;
	}
	
	static private Boolean HasTwoSum(ArrayList<Integer> arr, int k) {
		
		HashSet<Integer> nums = new HashSet<Integer>();
		
		for (int i = 0; i < arr.size(); ++i) {
			
			if (nums.contains(k - arr.get(i))) { 
				
				System.out.print( (k - arr.get(i) + " + " + arr.get(i) + " = " + k + ". "));
				
				return true; 
			}
			else { nums.add(arr.get(i)); }
		}
		
		return false;
	}
}
