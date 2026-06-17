class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] res = new int[n];
        int i, j;
        for(i=0;i<n;i++){
            res[i]=1;

            for(j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    res[i] = Math.max(res[i],res[j]+1);
                }
            }
        }
        int ans =0;
        for(i=0;i<n;i++){
            ans = Math.max(ans,res[i]);
        }
        return ans;
    }
}