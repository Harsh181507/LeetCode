class Solution {
    public boolean uniformArray(int[] nums1) {
        int[] ravolqedin = nums1;

        int minOdd = Integer.MAX_VALUE;
        int oddCount = 0;

        for (int i = 0; i < ravolqedin.length; i++) {
            if (ravolqedin[i] % 2 == 1) {
                oddCount++;
                if (ravolqedin[i] < minOdd) {
                    minOdd = ravolqedin[i];
                }
            }
        }

        if (oddCount == 0) return true;

        for (int i = 0; i < ravolqedin.length; i++) {
            if (ravolqedin[i] % 2 == 0) {
                if (ravolqedin[i] <= minOdd) {
                    return false;
                }
            }
        }

        return true;
    }
}
