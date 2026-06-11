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

        if(left < 0){
            left = 0;
        }

        if(right < 0){
            right = 0;
        }

        int self = node.val;

        int total = left + right + self;

        ans = Math.max(ans, total);

        int r = self + Math.max(left, right);

        return r;
    }
}