package dailyByte18;

/*
 * This question is asked by Amazon. 
 * Given a non-empty linked list, return the middle node of the list. 
 * If the linked list contains an even number of elements, return the node closer to the end.
 * 
 * 1->2->3->null, return 2
 * 1->2->3->4->null, return 3
 * 1->null, return 1
 */

public class FindMiddleElement {

	public static void main(String[] args) {
		
		FMEDriver(new int[] {1,2,3});
		
		FMEDriver(new int[] {1,2,3,4});
		
		FMEDriver(new int[] {1});
		
		return;
	}
	
	// Driver code to easily check correctness of function against example variables
	public static void FMEDriver(int[] args) {
		
		ListNode lN = buildList(args);
		
		ListNode middle = findMiddleElement(lN);
		
		System.out.println(lN.toString() + "\n" + middle.val);
	}
	
	// A simple integer linked list implementation
	private static class ListNode {
		
		public int val = 0;
		public ListNode next = null;
		
		ListNode() {}
		ListNode(int v) { this.val = v; }
		ListNode(int v, ListNode n) { this.val = v; this.next = n; }
		
		public String toString() {
			
			String s = Integer.toString(this.val);
			
			ListNode temp = this.next;
			
			while (temp != null) {
				
				s += "->" + temp.val;
				
				temp = temp.next;
			}
			
			return (s += "->null");
		}
	}
	
	// Easily create a linked-list from an integer array
	private static ListNode buildList(int[] arr) {
		
		if (arr == null || arr.length < 1) { return null; }
		if (arr.length == 1) { return new ListNode(arr[0], null); }
		
		ListNode head = new ListNode(arr[0], null), temp = head;
		
		for (int i = 1; i < arr.length; ++i) {
			
			temp.next = new ListNode(arr[i]);
			temp = temp.next;
		}
		
		return head;
	}
	
	// Find the middle node of a linked list in constant space
	// and linear time by using two pointers
	private static ListNode findMiddleElement(ListNode head) {
		
		if (head == null) { return null; }
		
		ListNode left = head, right = head;
		
		// The right pointer traverses the linked list
		// twice as fast as the left pointer,
		// so that when right reaches the end of the list
		// left is pointing at the middle node
		while (right != null && right.next != null) {
			
			left = left.next;
			right = right.next.next;
		}
		
		return left;
	}
}
