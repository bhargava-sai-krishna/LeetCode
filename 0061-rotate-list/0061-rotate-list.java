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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) 
        {
            return head;
        }
        int length = 1; 
        ListNode currNode1=head;
        while(currNode1.next != null) 
        {
            length++;
            currNode1 = currNode1.next;
        }
        k = k % length;
        if(k == 0) 
        {
            return head; 
        }
        currNode1=head;
        ListNode currNode2=head;
        int i=0;
        while(currNode1.next!=null)
        {
            if(i>=k)
            {
                currNode2=currNode2.next;
            }
            currNode1=currNode1.next;
            i=i+1;
        }
        currNode1=currNode2.next;
        currNode2.next=null;
        ListNode temp=currNode1;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=head;
        head=currNode1;
        return head;
    }
}