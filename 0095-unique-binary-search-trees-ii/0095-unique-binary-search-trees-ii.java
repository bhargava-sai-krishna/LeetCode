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
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        Map<String, List<TreeNode>> memo=new HashMap<>();
        return generateTrees(1, n, memo);
    }
    private List<TreeNode> generateTrees(int start, int end, Map<String, List<TreeNode>> memo){
        String key=start+"-"+end;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        List<TreeNode> trees=new ArrayList<>();
        if(start>end){
            trees.add(null);
            return trees;
        }
        for(int val=start;val<=end;val++){
            List<TreeNode> lt=generateTrees(start, val-1, memo);
            List<TreeNode> rt=generateTrees(val+1, end, memo);
            for(TreeNode l:lt){
                for(TreeNode r:rt){
                    TreeNode root=new TreeNode(val);
                    root.left=l;
                    root.right=r;
                    trees.add(root);
                }
            }
        }
        memo.put(key, trees);
        return trees;
    }
}