/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> lvlSum=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            int sum=0;
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            lvlSum.add(sum);
        }
        root.val=0;
        q.clear();
        q.offer(root);
        int currLvl=1;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(node.left!=null && node.right!=null){
                    int l=node.left.val, r=node.right.val;
                    node.left.val=lvlSum.get(currLvl)-l-r;
                    node.right.val=lvlSum.get(currLvl)-l-r;
                }
                else if(node.right!=null && node.left==null){
                    node.right.val=lvlSum.get(currLvl)-node.right.val;
                }
                else if(node.right==null && node.left!=null){
                    node.left.val=lvlSum.get(currLvl)-node.left.val;
                }
                if (node.left != null){ 
                    q.offer(node.left);
                }
                if (node.right != null){ 
                    q.offer(node.right);
                }
            }
            currLvl++;
        }
        return root;
    }
}