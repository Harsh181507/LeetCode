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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        fun(root);
        return ans;
    }
    public int fun(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = fun(node.left);
        int right = fun(node.right);

        left = Math.max(left,0);
        right = Math.max(right,0);

        int currPath = node.val + left + right;
        ans = Math.max(ans,currPath);

        int r = node.val + Math.max(left,right);
        return r;
    }
}