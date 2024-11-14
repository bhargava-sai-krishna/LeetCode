/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Queue<Node> q=new LinkedList<>();
        Map<Node, Node> map=new HashMap<>();
        q.add(node);
        map.put(node, new Node(node.val));
        while(!q.isEmpty()){
            Node temp=q.poll();
            Node clone=map.get(temp);
            for(Node neg:temp.neighbors){
                if(!map.containsKey(neg)){
                    map.put(neg, new Node(neg.val));
                    q.add(neg);
                }
                clone.neighbors.add(map.get(neg));
            }
        }
        return map.get(node);
    }
}