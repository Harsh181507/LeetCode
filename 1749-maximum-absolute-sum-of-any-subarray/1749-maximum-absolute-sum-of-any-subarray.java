class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int ans1 = maxsum(nums);
        int ans2 = minsum(nums);
        return Math.max(Math.abs(ans1), Math.abs(ans2));
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
        
        public static int minsum(int [] nums){
            int bestending = nums[0];
            int ans = nums[0];

            for(int i=1; i<nums.length; i++){
                int v1 =bestending + nums[i];
                int v2 = nums[i];

                bestending = Math.min(v1,v2);

                ans = Math.min(bestending,ans);
            }
            return ans;
        }
    
}