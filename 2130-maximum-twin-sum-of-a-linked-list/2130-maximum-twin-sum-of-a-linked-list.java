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
    public int pairSum(ListNode head) {
        int max = 0;
        ListNode hare = head;
        ListNode turtle = head;
        ListNode prev = null;

        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            ListNode temp = turtle.next;
            turtle.next = prev;
            prev = turtle;
            turtle = temp;
        }

        while(turtle != null) {
            max = Math.max(max, prev.val + turtle.val);
            prev = prev.next;
            turtle = turtle.next;
        }

        return max;
    }
}