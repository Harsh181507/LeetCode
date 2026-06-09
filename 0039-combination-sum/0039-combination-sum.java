class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        fun(candidates,n,0,new ArrayList<>(),target,0,res);
        return res;
    }
    public void fun(int[] candidates, int n, int idx, ArrayList<Integer> diary, int target, int sum, List<List<Integer>> res){

    if(idx == n){
        if(sum == target){
            res.add(new ArrayList<>(diary));
        }
        return;
    }

    fun(candidates, n, idx + 1, diary, target, sum, res);

    if(sum + candidates[idx] <= target){
        diary.add(candidates[idx]);
        sum += candidates[idx];

        fun(candidates, n, idx, diary, target, sum, res);

        diary.remove(diary.size() - 1);
        sum -= candidates[idx];
    }
}
}