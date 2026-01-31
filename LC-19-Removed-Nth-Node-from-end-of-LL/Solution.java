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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
    // Here, we move the fast ptr forward (n) places from head and then move slow and fast, so gap between slow and fast is n, so when fast reaches null (end), slow will be pointing 1 node before the one we want to remove
        ListNode dummy = new ListNode(-1, head);    // next of dummy is pointing to head
        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i=0;i<=n;i++){
            fast = fast.next;       // now fast has reached node with value 3 as per the example
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }           // once fast reaches null, slow will be one node before the one we want to remove

        slow.next = slow.next.next;     // remove the next node of slow
        return dummy.next;      
    }
}
/* Explanation
1. Take a dummy node whose next will point to head (start of the list)
2. Take slow and fast pointer nodes initialize them to dummy i.e. one node behind head and move fast n+1 places forward (n+1 as we start from one node behind head)
3. So fast is already forward now, move slow and fast 1 step forward each until fast reaches end. At this point slow will pointing to one node behind the one we want to remove.
4. Simply perform slow.next = slow.next.next
*/