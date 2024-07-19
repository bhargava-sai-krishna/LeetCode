class Solution {
    public int preInd = 0;
    public TreeNode builder(int[] inorder, int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd){
            return null;
        } 
        TreeNode node = new TreeNode(preorder[preInd++]);
        if (inStart == inEnd){
            return node;
        } 
        int inIndex = search(inorder, inStart, inEnd, node.val);
        node.left = builder(inorder, preorder, inStart, inIndex - 1);
        node.right = builder(inorder, preorder, inIndex + 1, inEnd);
        return node;
    }
    public int search(int[] inorder, int inStart, int inEnd, int data) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == data){
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return builder(inorder, preorder, 0, inorder.length - 1);
    }
}
