class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
        }
        if(total + target < 0 || (total + target) % 2 != 0){
            return 0;
        }
        int sum = (total + target) / 2;
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];
        for(int j = 0; j <= sum; j++){
            dp[n][j] = 0;
        }
        dp[n][0] = 1;
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= sum; j++){
                if(nums[i] > j){
                    dp[i][j] = dp[i+1][j];
                }else{
                    dp[i][j] = dp[i+1][j-nums[i]] + dp[i+1][j];
                }
            }
        }
        return dp[0][sum];
    }
}