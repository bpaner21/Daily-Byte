package dailyByte13;

/*
 * This question is asked by Google. 
 * Given two integer arrays, return their intersection.
 * Note: the intersection is the set of elements that are common to both arrays.
 * 
 * Ex: Given the following arrays...
 * 
 * nums1 = [2, 4, 4, 2], nums2 = [2, 4], return [2, 4]
 * nums1 = [1, 2, 3, 3], nums2 = [3, 3], return [3]
 * nums1 = [2, 4, 6, 8], nums2 = [1, 3, 5, 7], return []
 * 
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionofNumbers {

	public static void main(String[] args) {
		
		INDriver(new int[] {2, 4, 4, 2}, new int[] {2, 4});
		INDriver(new int[] {1,2,3,3}, new int[] {3,3});
		INDriver(new int[] {2,4,6,8}, new int[] {1,3,5,7});
		
		return;
	}
	
	public static void INDriver(int[] nums1, int[] nums2) {
		
		System.out.println("nums1 = " + Arrays.toString(nums1) + 
				", nums2 = " + Arrays.toString(nums2) + ": " + 
				Arrays.toString(Intersection(nums1, nums2)));
		
		return;
	}
	
	private static Integer[] Intersection(int[] nums1, int[] nums2) {
		
		ArrayList<Integer> intersection = new ArrayList<>();
		HashSet<Integer> lCount = new HashSet<>();
		
		for (int i : nums1) { lCount.add(i); }
		for (int j : nums2) {
			
			if (lCount.contains(j)) {
				intersection.add(j);
				lCount.remove(j);
			}
		}
			
		return intersection.toArray(new Integer[0]);
	}
}
