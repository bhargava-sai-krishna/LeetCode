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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode fast = head, slow = head, curr = head;
        Stack<ListNode> stack = new Stack<>();

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        while(second != null) {
            stack.push(second);
            second = second.next;
        }

        while(!stack.isEmpty()) {
            ListNode temp = curr.next;
            ListNode poped = stack.pop();
            curr.next = poped;
            poped.next = temp;
            curr = temp;
        }
    }
}