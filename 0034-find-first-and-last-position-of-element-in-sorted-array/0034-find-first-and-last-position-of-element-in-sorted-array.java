class Solution {

    public int[] searchRange(int[] nums, int target) {

        int[] res = {-1, -1};

        res[0] = FirstOccurrence(nums, target);
        res[1] = LastOccurrence(nums, target);

        return res;
    }

    public int FirstOccurrence(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while(start <= end) {

            int mid = start + (end - start) / 2;

            if(nums[mid] < target) {
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;    
                end = mid - 1; 
            }
        }

        return ans;
    }

    public int LastOccurrence(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while(start <= end) {

            int mid = start + (end - start) / 2;

            if(nums[mid] < target) {
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1; 
            }
        }

        return ans;
    }
}