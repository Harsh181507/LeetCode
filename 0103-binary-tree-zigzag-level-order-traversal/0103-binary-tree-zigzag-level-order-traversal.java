class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int leftToRight = 1;
        while(!q.isEmpty()){
            int levelsize = q.size();
            List<Integer> temp = new ArrayList<>(Collections.nCopies(levelsize, 0));
            int first = 0;
            int last = levelsize - 1;
            while(levelsize-- > 0){
                TreeNode t = q.poll();
                if(leftToRight == 1){
                    temp.set(first, t.val);
                    first++;
                }else{
                    temp.set(last, t.val);
                    last--;
                }
                if(t.left != null){
                    q.add(t.left);
                }
                if(t.right != null){
                    q.add(t.right);
                }
            }
            res.add(temp);
            leftToRight = 1 - leftToRight;
        }
        return res;
    }
}