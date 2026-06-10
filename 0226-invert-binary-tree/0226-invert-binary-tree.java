class Solution {
    public TreeNode invertTree(TreeNode root) {
        isInverted(root);
        return root;
    }
    public void isInverted(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        isInverted(root.left);
        isInverted(root.right);
    }
}