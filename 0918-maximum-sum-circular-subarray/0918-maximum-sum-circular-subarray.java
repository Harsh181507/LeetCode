class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int ans1 = maxsum(nums);
        if (ans1 < 0){
            return ans1;
        }
        int ans2 = minsum(nums);

        return Math.max(ans1, ans2);

    }

    public static int maxsum(int [] nums){
        int bestending = nums[0];
        int ans = nums[0];
        for(int i =1; i<nums.length; i++){
            int v1 = bestending + nums[i];
            int v2 = nums[i];
            bestending = Math.max(v1,v2);
            ans = Math.max(ans, bestending);
        }
        return ans;
    }

    public static int minsum (int [] nums){
        int bestending = nums[0];
        int ans = nums[0];
        int sum =0;
        for(int i=1; i<nums.length; i++){
            int v1 = bestending + nums[i];
            int v2 = nums[i];

            bestending = Math.min(v1, v2);
            ans = Math.min(ans, bestending);
        }
        for(int i =0; i<nums.length;i++){
            sum+=nums[i];
        }
        return sum - ans;
    }
    


}