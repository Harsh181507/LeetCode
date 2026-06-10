class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        if(root == null){
            return null;
        }

        if(root.val == val){
            return root;
        }

        TreeNode r = null;

        if(root.val > val){
            r = searchBST(root.left, val);
        }else{
            r = searchBST(root.right, val);
        }

        return r;
    }
}