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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr1 = list1;
        for (int i = 0; i < a - 1; i++) {
            curr1 = curr1.next;
        }
        ListNode prev_a = curr1;
        for (int i = 0; i < b - a + 1; i++) {
            curr1 = curr1.next;
        }
        ListNode next_b = curr1.next;
        prev_a.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = next_b;
        return list1;
    }
}