package dailyByte15;

/*
 * This question is asked by Apple.
 * Given two sorted linked lists,
 * merge them together in ascending order
 * and return a reference to the merged list
 * 
 * Ex: Given the following lists...
 * 
 * list1 = 1->2->3, list2 = 4->5->6->null,
 * return 1->2->3->4->5->6->null
 * 
 * list1 = 1->3->5, list2 = 2->4->6->null,
 * return 1->2->3->4->5->6->null
 * 
  * list1 = 4->4->7, list2 = 1->5->6->null,
 * return 1->4->4->5->6->7->null
 */

public class MergeLinkedLists {
	
	public static void main(String[] args) {
		
		MLLDriver(new int[] {1, 2, 3}, new int[] {4, 5, 6});
		MLLDriver(new int[] {1, 3, 5}, new int[] {2, 4, 6});
		MLLDriver(new int[] {4, 4, 7}, new int[] {1, 5, 6});
		
		// 2 sets of 15 integers
		MLLDriver(new int[] {9, 21, 27, 35, 39, 40, 43, 51, 54, 58, 63, 66, 78, 87, 92}, new int[] {5, 13, 16, 31, 34, 38, 41, 43, 46, 48, 51, 66, 84, 92, 93});
		
		// 2 sets of 50 integers
		MLLDriver(new int[] {1, 4, 5, 9, 11, 12, 23, 25, 28, 42, 44, 46, 50, 51, 55, 62, 64, 65, 68, 70, 72, 73, 85, 87, 88, 91, 95, 98, 103, 107, 108, 119, 133, 139, 141, 142, 147, 156, 157, 159, 163, 164, 167, 169, 174, 184, 185, 188, 190, 196}, new int[] {1, 8, 17, 19, 32, 36, 38, 44, 47, 48, 54, 58, 59, 69, 73, 74, 75, 77, 78, 79, 88, 90, 92, 93, 95, 101, 103, 105, 110, 113, 118, 122, 124, 130, 138, 139, 147, 157, 158, 164, 166, 172, 176, 181, 185, 187, 190, 191, 192, 199});
		
		// 1 set of 20 and 1 set of 80 integers
		MLLDriver(new int[] {26, 84, 98, 107, 108, 110, 117, 118, 123, 139, 140, 148, 154, 158, 161, 163, 171, 185, 187, 198}, new int[] {2, 7, 8, 9, 13, 19, 24, 25, 26, 28, 30, 32, 33, 36, 37, 55, 56, 59, 60, 63, 67, 68, 74, 75, 76, 77, 78, 80, 86, 89, 92, 93, 95, 97, 102, 104, 105, 107, 108, 110, 112, 116, 117, 118, 121, 123, 126, 127, 129, 130, 131, 133, 134, 140, 141, 146, 147, 150, 152, 153, 154, 157, 158, 160, 165, 167, 168, 175, 177, 178, 179, 180, 182, 183, 184, 190, 193, 194, 195, 196});
		
		return;
	}
	
	// Simple integer Linked List implementation
	private static class ListNode {
		int val = 0;
		ListNode next = null;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		
		public String toString() {
			
			ListNode lN = this;
			
			String s = Integer.toString(lN.val);
			
			lN = lN.next;
			
			while (lN != null) {
				
				s += "->" + lN.val;
				
				lN = lN.next;
			}
			
			s += "->" + lN;
			
			return s;
		}
	}
	
	// Driver code to create and merge two linked lists
	// from input arrays
	public static void MLLDriver(int[] list1, int[] list2) {
		
		ListNode l1 = buildList(list1), l2 = buildList(list2);
		
		System.out.println("list1 = " + l1.toString() + ",\nlist2 = " + l2.toString() + ",");
		
		ListNode mL = mergeTwoLists(l1, l2);
		
		System.out.println("merged list = " + mL.toString() + "\n");
		
		return;
	}
	
	// Function to easily construct a possibly null-terminated linked list from an input array of integers
	private static ListNode buildList(int[] entries) {
		
		if (entries == null || entries.length == 0) { return new ListNode(); }
		
		if (entries.length == 1) { return new ListNode(entries[0], null); }
		
		ListNode lN = new ListNode(entries[0], null), temp = lN;
		
		for (int i = 1; i < entries.length; ++i) {
			
			temp.next = new ListNode(entries[i]);
			
			temp = temp.next;
		}
		
		return lN;
	}
	
	// A linear, constant-space implementation that does not fill up the call-stack
	// with recursive function calls
	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if (l1 == null) { return l2; }
		if (l2 == null) { return l1; }
		
		ListNode tempHead = new ListNode(), temp = tempHead;
		
		// Sorts the two lists in ascending order until the end of one list is reached
		while (l1 != null && l2 != null) {
			
			if (l1.val <= l2.val) {
				
				temp.next = l1;
				l1 = l1.next;
			}
			else {
				
				temp.next = l2;
				l2 = l2.next;
			}
			
			temp = temp.next;
		}
		
		// When one list has been completely sorted, 
		// the (already sorted) values of the remaining list
		// are added to the new, merged list
		temp.next = (l1 != null) ? l1 : l2;
		
		return tempHead.next;
	}

}
