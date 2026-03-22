class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean hasEven = false, hasOdd = false;
        for (int num : nums1) {
            if (num % 2 == 0) hasEven = true;
            else hasOdd = true;
        }
        return true;
    }
}
