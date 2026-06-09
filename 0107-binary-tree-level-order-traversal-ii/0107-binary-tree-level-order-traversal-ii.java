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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        if(root == null){
            return res;
        }
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> temp = new ArrayList<>();

            while(levelSize -- > 0){
                TreeNode t = q.peek();
                q.poll();
                temp.add(t.val);
                if(t.left != null){
                    q.add(t.left);
                }
                if(t.right!= null){
                    q.add(t.right);
                }
            }
            res.add(temp);
        }
        Collections.reverse(res);
        return res;
    }
}