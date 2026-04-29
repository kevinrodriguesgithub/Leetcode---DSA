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
    public ListNode oddEvenList(ListNode head) {
        
    // Using extra space - Method 1
        if(head == null){       // empty list - edge case
            return null;
        }

        if(head.next == null){  // edge case - single element in list
            return head;
        }

    /*    ListNode curr = head;

        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        boolean odd = true;
        while(curr != null){
            if(odd){
                oddList.add(curr.val);
                odd = false;
            }
            else{
                evenList.add(curr.val);
                odd = true;
            }       // oddList = {1,3,5} ; evenList = {2,4}
            curr = curr.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode start = dummy;
        for(int i=0;i<oddList.size();i++){
            dummy.next = new ListNode(oddList.get(i));
            dummy = dummy.next;
        }

        for(int i=0;i<evenList.size();i++){
            dummy.next = new ListNode(evenList.get(i));
            dummy = dummy.next;
        }
        return start.next;  */

    // Using O(1) space

        ListNode odd = head;
        ListNode even = odd.next;
        ListNode evenHead = even;   // will be needed to connect to end of odd list

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;       // connect end of odd to start of even

        return head;
    }
}

/* Explanation - Using extra space
1. Base case, if head is null, it's an empty list; If head.next is null, there's only 1 element
2. Declare two different arraylist - One of odd index numbers and other for even index numbers
3. Alternatvely, save each number to respective list
4. Now, Create a dummy node, which will be one node behind our actual start, so that we can return dummy.next
5. Now, iterate over odd list, and keep on adding a newNode with a value from odd list
6. Now, we have all the odd indexed nodes chained, next iterate over the even list, and similarly add a newNode with a value from even List
7. Finally, return dummy.next, and we have our modified list

Explanation - Method 2 - O(1) space
1. Base case, if head is null, it's an empty list; If head.next is null, there's only 1 element
2. Have a odd pointer at the start (head) and even pointer just next to the head
3. While even pointer node is not null or it's next is not null, connect odd's next to even.next and even's next as odd.next, as we want to skip one node after each odd and even to attach the node's as per requirements
4. Now, we have the odd nodes chained togther and even nodes chained together, but we need to connect even chained nodes at the end of odd chained nodes.
5. Hence, before the start of the loop, we store the evenHead (start of even chained nodes) and connect this to the end of the odd chained nodes
6. Thus, we achieved the result
*/