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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int temp = 0;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                current.next = new ListNode(temp);
                current = current.next;
                temp = 0;
            } 
            else {
                temp += head.val;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
