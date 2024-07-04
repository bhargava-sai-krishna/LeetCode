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
	public int getHeight(TreeNode node)
	{
		if(node==null)
		{
			return 0;
		}
		int leftHeight=getHeight(node.left);
		int rightHeight=getHeight(node.right);
        if ((leftHeight == -1 || rightHeight == -1) || (leftHeight-rightHeight>1 ||rightHeight-leftHeight>1))
        {
            return -1;
        }
		if(leftHeight>=rightHeight)
		{
			return leftHeight+1;
		}
		else
		{
			return rightHeight+1;
		}
	}
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        if(getHeight(root)==-1)
        {
            return false;
        }
        return true;
    }
}