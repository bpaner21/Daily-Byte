package dailyByte17;

/* 
 * This question is asked by Google. 
 * Given a linked list and a value, 
 * remove all nodes containing the provided value, 
 * and return the resulting list.
 * 
 * Ex: Given the following linked lists and values...
 * 
 * 1->2->3->null, value = 3, return 1->2->null
 * 8->1->1->4->12->null, value = 1, return 8->4->12->null
 * 7->12->2->9->null, value = 7, return 12->2->9->null
 */

public class RemoveValue {

	public static void main(String[] args) {
		
		RVDriver(new int[] {1,2,3}, 3);
		RVDriver(new int[] {8,1,1,4,12}, 1);
		RVDriver(new int[] {7,12,2,9}, 7);
		
		return;
	}
	
	// Driver code to create a linked list from an input array
	// and remove all nodes with a value of n
	public static void RVDriver(int[] list, int n) {
		
		ListNode l1 = buildList(list);
		
		System.out.println(l1.toString() + ", value = " + n + ",");
		
		ListNode r1 = removeValue(l1, n);
		
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
	
	private static ListNode removeValue(ListNode list, int n) {
		
		ListNode tempHead = new ListNode(0, list), temp = tempHead;
		
		// While temp.next is valid, and so
		// and so temp.next.val will not create an error
		while (temp.next != null) {
			
			if ( temp.next.val == n) {
				
				// Remove temp.next if equal to n
				// by reassigning temp's pointer
				// to the next node over
				temp.next = temp.next.next;
			}
			else {
				
				// If temp.next.val != n,
				// move on
				temp = temp.next;
			}
		}
		
		return tempHead.next;
	}
}
