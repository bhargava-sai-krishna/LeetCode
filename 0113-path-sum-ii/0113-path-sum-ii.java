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
    public void helper(TreeNode node, int targetSum, List<List<Integer>> ans, int currSum, List<Integer> currPath){
        if(node==null){
            return;
        }
        currSum+=node.val;
        currPath.add(node.val);
        if(node.left==null && node.right==null && currSum==targetSum){
            ans.add(new ArrayList<>(currPath));
        }
        helper(node.left, targetSum, ans, currSum, currPath);
        helper(node.right, targetSum, ans, currSum, currPath);
        currPath.remove(currPath.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(root, targetSum, ans, 0, new ArrayList<>());
        return ans;
    }
}