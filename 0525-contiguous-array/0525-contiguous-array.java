class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int zero = 0;
        int one = 0;
        HashMap <Integer, Integer> f = new HashMap<>();
        int res =0;

        for(int i=0; i<n; i++){
            if(nums[i]==0){
                zero++;
            }else{
                one++;
            }
            int diff = zero - one;
            if(diff == 0){
                res = Math.max(res,i+1);
                continue;
            }
            if(!f.containsKey(diff)){
                f.put(diff, i);
            }else{
                int idx = f.get(diff);
                int len = i - idx;
                res = Math.max(len, res);
            }
        }
        return res;
    }
}