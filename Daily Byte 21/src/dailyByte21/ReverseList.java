package dailyByte21;

/*
 * This question is asked by Facebook. 
 * Given a linked list, containing unique values, reverse it, and return the result.
 * 
 * Ex: Given the following linked lists...
 * 
 * 1->2->3->null, 
 * return a reference to the node that contains 3 which points to a list that looks like the following: 
 * 3->2->1->null
 * 
 * 7->15->9->2->null, 
 * return a reference to the node that contains 2 which points to a list that looks like the following: 
 * 2->9->15->7->null
 * 
 * 1->null, 
 * return a reference to the node that contains 1 which points to a list that looks like the following: 
 * 1->null
 */

public class ReverseList {
	
	public static void main(String[] args) {
		
		RLDriver(new int[] {1, 2, 3});
		RLDriver(new int[] {7, 15, 9, 2});
		RLDriver(new int[] {1});
		RLDriver(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		
		return;
	}
	
	private static void RLDriver(int[] arr) {
		
		ListNode head = buildList(arr);
		
		System.out.println(head.toString());
		
		ListNode reverse = reverseList(head);
		
		System.out.println("Reversed: " + reverse.toString() + "\n");
		
		return;
	}
	
	private static class ListNode {
		
		public int val = 0;
		public ListNode next = null;
		
		ListNode(int v) {val = v;}
		
		public String toString() {
			
			String s = Integer.toString(val);
			
			ListNode lN = next;
			
			while (lN != null) {
				
				s += "->" + lN.val;
				lN = lN.next;
			}
			
			return (s += "->null");
		}
	}
	
	private static ListNode buildList(int[] arr) {
		
		if (arr.length == 1) { return new ListNode(arr[0]); }
		
		ListNode head = new ListNode(arr[0]), temp = head;
		
		for (int i = 1; i < arr.length; ++i) {
			
			temp.next = new ListNode(arr[i]);
			temp = temp.next;
		}
		
		return head;
	}
	
	private static ListNode reverseList(ListNode head) {
	
		ListNode oldNext, newNext = null;
		
		while (head != null) {
			
			oldNext = head.next;
			
			head.next = newNext;
			
			newNext = head;
			
			head = oldNext;
		}
		
		return newNext;
	}

}
