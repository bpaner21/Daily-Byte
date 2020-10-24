package dailyByte16;

/*
 * This question is asked by Facebook. 
 * Given a linked list and a value n, remove the nth to last node and return the resulting list.
 * 
 * Ex: Given the following linked lists...
 * 
 * 1->2->3->null, n = 1, return 1->2->null
 * 1->2->3->null, n = 2, return 1->3->null
 * 1->2->3->null, n = 3, return 2->3->null
 */

public class RemoveNthToLastNode {
	
	public static void main(String[] args) {
		
		RNNDriver(new int[] {1,2,3}, 1);
		RNNDriver(new int[] {1,2,3}, 2);
		RNNDriver(new int[] {1,2,3}, 3);
		
		return;
	}
	
	// Driver code to create a linked list and remove the Nth node
	public static void RNNDriver(int[] list, int n) {
		
		ListNode l1 = buildList(list);
		
		System.out.println(l1.toString() + ", n = " + n + ",");
		
		ListNode r1 = removeNthNode(l1, n);
		
		System.out.println("return " + r1.toString() + "\n");
		
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
	
	private static ListNode removeNthNode(ListNode l1, int n) {
		
		ListNode tempHead = new ListNode(0, l1), right = tempHead, left = tempHead;
		
		// Create an n+1-sized gap between left and right
		for (int i = 0; i < n + 1; ++i) {
			
			right = right.next;
		}
		
		// While right has not reached the end of the list,
		// continue incrementing both left and right
		while (right != null) {
			
			left = left.next;
			right = right.next;
		}
		
		// left.next is the node to be removed,
		// so simply reassign left.next to the node after
		left.next = left.next.next;
		
		return tempHead.next;
	}
}
