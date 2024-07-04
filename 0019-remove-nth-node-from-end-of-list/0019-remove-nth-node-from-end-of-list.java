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
        ListNode currNode1 = head;
        ListNode currNode2 = head;

        while (currNode1 != null && n > 0) 
        {
            currNode1 = currNode1.next;
            n--;
        }
        if (currNode1 == null) 
        {
            return head.next;
        }
        while (currNode1.next != null) 
        {
            currNode1 = currNode1.next;
            currNode2 = currNode2.next;
        }
        currNode2.next = currNode2.next.next;
        return head;
    }
}
