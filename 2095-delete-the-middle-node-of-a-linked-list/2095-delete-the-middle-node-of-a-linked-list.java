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
         if (head == null || head.next == null) {
            return null;
        }
        
        ListNode prev = null;
        ListNode turtle = head;
        ListNode hare = head;

        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            prev = turtle;
            turtle = turtle.next;
        }

        prev.next = turtle.next;

        return head;
    }
}