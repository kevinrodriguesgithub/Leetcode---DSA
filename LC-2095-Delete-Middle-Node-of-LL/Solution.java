/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode deleteMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode extra = new ListNode(-1, slow);    // this will be one node behind slow which will help in deletion

        if(head.next == null){      // If Single element in list
            return null;    
        }

        while(fast != null && fast.next != null){
            extra = extra.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        extra.next = extra.next.next;
        return head;
    }
}

/* Explanation
1. Use fast and slow pointers, where fast moves forward 2 nodes at a time and slow moves 1 node
2. When fast reaches end, slow will be at the middle, this is the node we want to remove
3. But in order to remove this node, we need to have it's previous node so that we can attach previous to the next node of the middle node
4. Use ListNode extra which will always be one step behind slow
5. Thus we fast reaches end, slow will be at the middle, so we can simply do extra.next = extra.next.next and thus middle node will be removed

*/