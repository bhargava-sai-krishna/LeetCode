/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node rightNode=null;
            for(int i=q.size();i>0;i--){
                Node current=q.poll();
                current.next=rightNode;
                rightNode=current;
                if(current.right!=null){
                    q.offer(current.right);
                    q.offer(current.left);
                }
            }
        }
        return root;
    }
}