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
    public int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode ans=head;
        while(ans!=null && ans.next!=null){
            ListNode gcdNode=new ListNode(gcd(ans.val, ans.next.val));
            gcdNode.next=ans.next;
            ans.next=gcdNode;
            ans=gcdNode.next;
        }
        System.gc();
        return head;
    }
}