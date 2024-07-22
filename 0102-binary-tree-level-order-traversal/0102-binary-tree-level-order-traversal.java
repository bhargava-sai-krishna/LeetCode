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
    public int height(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        return (lheight>rheight)?lheight+1:rheight+1;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        int h = height(root);
        for (int i=0;i<h;i++) {
            ans.add(getCurrentLevel(root, i + 1));
        }
        return ans;
    }

    public List<Integer> getCurrentLevel(TreeNode root, int level) {
        List<Integer> temp = new ArrayList<>();
        if(root==null) {
            return temp;
        }
        if(level==1) {
            temp.add(root.val);
        } 
        else if(level>1) {
            temp.addAll(getCurrentLevel(root.left, level - 1));
            temp.addAll(getCurrentLevel(root.right, level - 1));
        }
        return temp;
    }
}