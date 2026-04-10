class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] count = new int[n]; 
        Arrays.fill(count, 1);

        for(int i=0; i<n; i++){
            int ans = 1;
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    int a = 1 + dp[j];
                    if(a==ans) count[i] += count[j]; 
                    else if(a>ans){ 
                        count[i] = count[j]; 
                        ans = a;
                    }
                }
            }
            dp[i] = ans;
        }

 
        int max = -1; 
        int res = 0; 
        for(int i=0; i<n; i++){
            if(max<dp[i]){
                max = dp[i];
                res = count[i];
            }else if(max==dp[i]){
                res += count[i];
            }
        }
        return res;
    }
}