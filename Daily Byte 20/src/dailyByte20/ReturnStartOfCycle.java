package dailyByte20;

/*
 * This question is asked by Apple. 
 *  * Given a potentially cyclical linked list where each value is unique, 
 *  return the node at which the cycle starts. If the list does not contain a cycle, return null.
 * 
 * Ex: Given the following linked lists...
 * 
 * 1->2->3, return null
 * 1->2->3->4->5->2 (5 points back to 2), return a reference to the node containing 2
 * 1->9->3->7->7 (7 points to itself), return a reference to the node containing 7
 */

import java.util.HashMap;

public class ReturnStartOfCycle {

	public static void main(String[] args) {
		
		RSCDriver(new int[] {1,2,3});
		RSCDriver(new int[] {1,2,3,4,5,2});
		RSCDriver(new int[] {1,9,3,7,7});
		
		
		return;
	}
	
	public static void RSCDriver(int[] arr) {
		
		ListNode head = buildList(arr), start = startOfCycle(head);
		
		if (start == null) {
			
			System.out.println(head.toString());
		}
		else {
			
			String s = Integer.toString(arr[0]);
			
			for (int i = 1; i < arr.length; ++i) {
				
				s += "->" + arr[i];
			}
			
			System.out.println(s + " return " + start.val);
		}
		
		return;
	}
	
	// Simple Linked List implementation
	private static class ListNode {
		
		public int val = 0;
		public ListNode next = null;
		
		ListNode(int v) { this.val = v; }
		
		// toString() only works for acyclic lists
		public String toString() {
			
			String s = Integer.toString(this.val);
			
			ListNode lN = this.next;
			
			while (lN != null) {
				
				s += "->" + lN.val;
				lN = lN.next;
			}
			
			return (s += "->null");
		}
	}
	
	// Build a possibly cyclic linked list from an integer array
	private static ListNode buildList(int[] arr) {
		
		HashMap<Integer, ListNode> Nodes = new HashMap<>();
		
		ListNode dummyHead = new ListNode(-1), temp = dummyHead;
		
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
		
		return dummyHead.next;
	}
	
	private static ListNode startOfCycle(ListNode head) {
		
		ListNode slow = head, fast = head;
		
		// First check if there is a cycle
		// If the while condition is met,
		// there is no cycle
		while (fast != null && fast.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;
			
			// If there is a cycle,
			// find its first entry in the linked list;
			if (slow == fast) {
				
				// The distance between the head of the list
				// and the entry point of the cycle
				// is the same as the distance between 
				// the entry point of the cycle and where
				// the slow pointer met the fast pointer
				//
				// As a result, the entry point can be found
				// by creating a new pointer at the head of the list
				// and incrementing both this new pointer and either
				// of the previous pointers until they meet again
				ListNode entry = head;
				
				while (slow != entry) {
					
					slow = slow.next;
					entry = entry.next;
				}
				
				return entry;
			}
		}
		
		return null;
	}
}
