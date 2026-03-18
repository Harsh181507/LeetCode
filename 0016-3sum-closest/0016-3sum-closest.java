class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2];
        for(int i=0; i<n-2; i++){
            int x = nums[i];
            int l = i+1;
            int r = n-1;
            while(l<r){
                int sum = x+nums[l]+nums[r];
                int diff = Math.abs(sum-target);
                if(diff<=min){
                    min = diff;
                    closest = sum;
                }
                if(sum < target){
                    l++;
                }
                else if(sum > target){
                    r--;
                }
                else{
                    return sum;
                }
            }
        }
        return closest;
    }
}