/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
        Node currNode=head;
        while(currNode!=null)
        {
            map.put(currNode,new Node(currNode.val));
            currNode=currNode.next;
        }
        currNode=head;
        while(currNode!=null)
        {
            map.get(currNode).next=map.get(currNode.next);
            map.get(currNode).random=map.get(currNode.random);
            currNode=currNode.next;
        }
        return map.get(head);
    }
}