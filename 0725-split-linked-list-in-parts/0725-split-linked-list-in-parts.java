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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] list=new ListNode[k];
        ListNode currNode=head;
        int len=0;
        while(currNode!=null)
        {
            currNode=currNode.next;
            len=len+1;
        }
        int rem=len%k, req=len/k;
        currNode=head;
        for(int i=0;currNode!=null;i++)
        {
            int count=req+(rem>0?1:0);rem=rem-1;
            list[i]=currNode;
            for(;count>1;count--)
            {
                currNode=currNode.next;
            }
            if(currNode==null)
            {
                break;
            }
            ListNode temp=currNode.next;
            currNode.next=null;
            currNode=temp;
        }
        return list;
    }
}