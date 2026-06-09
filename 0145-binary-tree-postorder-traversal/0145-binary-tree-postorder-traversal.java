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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer>res= new ArrayList<>();
        postorder(root,res);
        return res;
    }
    public void postorder(TreeNode node, ArrayList<Integer> res){
        if(node == null){
            return;
        }
        postorder(node.left,res); //left
        postorder(node.right,res); //right
        res.add(node.val); //selft

    }
}