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
 *         this.left = left;chrome-extension://debbebdlpbnpnnicofdpociejpmokdnm/resources/icon.png$0
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        TreeNode root1 = root.left;
        TreeNode root2 = root.right;
        return symmetric(root1,root2);
    }
    public boolean symmetric(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        boolean r1 = symmetric(root1.left, root2.right);
        boolean r2 = symmetric(root1.right, root2.left);

        if(r1 == true && r2 == true){
            return true;
        }else{
            return false;
        }
    }
}