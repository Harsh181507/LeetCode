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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        fun(root,res);
        return res;
    }
    public void fun (TreeNode node,ArrayList<Integer> res){
        if(node == null){
            return;
        }
        
        fun(node.left,res); //left
        res.add(node.val); //khud
        fun(node.right,res); // right
        
    }
}