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
    public void recur(TreeNode node, List<Integer> nums, String str){
        str+=node.val;
        if(node.left==null && node.right==null){
            nums.add(Integer.parseInt(str));
            return;
        }
        if(node.left!=null){
            recur(node.left, nums, str);
        }
        if(node.right!=null){
            recur(node.right, nums, str);
        }
    }
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        List<Integer> nums=new ArrayList<>();
        recur(root, nums, "");
        int ans=0;
        for(int i:nums){
            ans+=i;
        }
        return ans;
    }
}