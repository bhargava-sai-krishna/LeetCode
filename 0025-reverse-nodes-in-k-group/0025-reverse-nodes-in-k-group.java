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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;
        while (current != null && count < k) 
        {
            current = current.next;
            count++;
        }
        current = head;
        if (count == k) 
        {
            count = 0;
            while (current != null && count < k) 
            {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }
            head.next = reverseKGroup(current, k);
        }
        return count == k ? prev : head;
    }
}