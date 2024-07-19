import java.util.HashMap;

class Solution {
    public int preInd=0;
    public HashMap<Integer, Integer> inorderMap=new HashMap<>();

    public TreeNode builder(int[] inorder, int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        TreeNode node = new TreeNode(preorder[preInd++]);
        if (inStart == inEnd) return node;
        int inIndex = inorderMap.get(node.val);
        node.left = builder(inorder, preorder, inStart, inIndex - 1);
        node.right = builder(inorder, preorder, inIndex + 1, inEnd);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return builder(inorder, preorder, 0, inorder.length - 1);
    }
}
