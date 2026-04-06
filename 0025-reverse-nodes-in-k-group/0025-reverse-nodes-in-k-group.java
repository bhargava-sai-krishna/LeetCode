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
        ListNode ans = new ListNode(0);
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        ListNode ansCurr = ans;

        while(curr != null) {
            for(int i = 0; i < k && curr !=null; i++) {
                stack.push(curr);
                curr = curr.next;
            }

            if(stack.size() < k) {
                ansCurr.next = stack.firstElement();
                break;
            }

            while(!stack.isEmpty()) {
                ansCurr.next = stack.pop();
                ansCurr = ansCurr.next;
                ansCurr.next = null;
            }
        }

        return ans.next;
    }
}