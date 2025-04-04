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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        if(root!=null){
            helper(root, ans, "");
        }
        return ans;
    }
    public void helper(TreeNode root, List<String> ans, String path){
        if(root.left==null && root.right==null){
            ans.add(path+root.val);
        }
        if(root.left!=null){
            helper(root.left, ans, path+root.val+"->");
        }
        if(root.right!=null){
            helper(root.right, ans, path+root.val+"->");
        }
    }
}