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
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) return null;

      PriorityQueue<ListNode> data = new PriorityQueue<>((a, b) -> a.val - b.val);
      for (ListNode node : lists) 
      {
        if (node != null) data.add(node);
      }
      ListNode dummy = new ListNode(-1);
      ListNode curr = dummy;
      while (!data.isEmpty()) 
      {
        ListNode minNode = data.poll();
        curr.next = minNode;
        curr = curr.next;
        if (minNode.next != null) 
        {
            data.add(minNode.next);
        }
      }
      return dummy.next;
  }
}