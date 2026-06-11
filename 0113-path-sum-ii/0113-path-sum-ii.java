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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> diary = new ArrayList<>();
        fun(root, 0, targetSum, diary);
        return res;
    }
    public void fun(TreeNode root,int sum,int targetSum,List<Integer> diary){
        if(root == null){
            return;
        }
        sum += root.val;
        diary.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                res.add(new ArrayList<>(diary));
            }
            diary.remove(diary.size() - 1);
            return;
        }
        fun(root.left, sum, targetSum, diary);
        fun(root.right, sum, targetSum, diary);
        diary.remove(diary.size() - 1);
    }
}