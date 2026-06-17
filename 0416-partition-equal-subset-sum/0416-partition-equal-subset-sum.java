class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
        }
        if(total % 2 != 0){
            return false;
        }
        int sum = total / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int j = 0; j <= sum; j++){
            dp[n][j] = false;
        }
        dp[n][0] = true;
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= sum; j++){
                if(nums[i] > j){
                    dp[i][j] = dp[i+1][j];
                }else{
                    dp[i][j] = dp[i+1][j-nums[i]] || dp[i+1][j];
                }
            }
        }
        return dp[0][sum];
    }
}