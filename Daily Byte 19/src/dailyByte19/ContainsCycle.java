package dailyByte19;

/*
 * This question is asked by Microsoft. 
 * Given a linked list, containing unique numbers, return whether or not it has a cycle.
 * Note: a cycle is a circular arrangement (i.e. one node points back to a previous node)
 * 
 * Ex: Given the following linked lists...
 * 
 * 1->2->3->1 -> true (3 points back to 1)
 * 1->2->3 -> false
 * 1->1 true (1 points to itself)
 */

import java.util.HashMap;

public class ContainsCycle {

	public static void main(String[] args) {
		
		CCDriver(new int[] {1,2,3,1});
		CCDriver(new int[] {1,2,3});
		CCDriver(new int[] {1,1});
		
		System.out.println("DONE");
		
		return;
	}
	
	// Driver function to test correctness of function
	// against example problems
	public static void CCDriver(int[] args) {
		
		ListNode lN = buildList(args);
		
		if (containsCycle(lN)) {
			
			String s = Integer.toString(args[0]);
			
			for (int i = 1; i < args.length; ++i) {
				
				s += "->" + args[i];
			}
			
			System.out.println(s + " true");
		}
		else {
			System.out.println(lN.toString() + " false");
		}
		
		return;
	}
	
	// Simple linked list implementation
	private static class ListNode {
		
		public int val = 0;
		public ListNode next = null;
		
		ListNode(int v) { this.val = v; this.next = null; }
		
		public String toString() {
			
			String s = Integer.toString(this.val);
			
			ListNode lN = this.next;
			
			while (lN != null)
			{
				s += "->" + lN.val;
				lN = lN.next;
			}
			
			s += "->null";
			
			return s;
		}
	}
	
	// Easily create a linked list of unique nodes
	// from an integer array
	private static ListNode buildList(int[] arr) {
		
		HashMap<Integer, ListNode> Nodes = new HashMap<>();
		
		ListNode temp = new ListNode(-1), head = temp;
		
		for (int i = 0; i < arr.length; ++i) {
			
			if (Nodes.containsKey(arr[i])) {
				
				temp.next = Nodes.get(arr[i]);
			}
			else {
				
				ListNode newNode = new ListNode(arr[i]);
				
				Nodes.put(arr[i], newNode);
				
				temp.next = newNode;
			}
			
			temp = temp.next;
		}
		
		return head.next;
	}
	
	private static boolean containsCycle (ListNode head) {
		
		if (head == null) { return false; }
		
		ListNode slow = head, fast = head.next;

		while (slow != fast) {
			
			if (fast == null || fast.next == null) { return false; }
			
			else {
				
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		
		return true;
	}
}
