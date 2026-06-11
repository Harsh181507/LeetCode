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
    TreeNode prev = null;
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return ans;
    }
    public void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        if(prev == null){
            prev = node;
        }else{
            if(node.val <= prev.val){
                ans = false;
            } 
            prev = node;
        }
        inorder(node.right);
    }
}