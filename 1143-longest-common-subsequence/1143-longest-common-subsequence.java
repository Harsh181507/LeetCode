class Solution {
    public int longestCommonSubsequence(String s1, String s2) {

        int ind1 = s1.length();
        int ind2 = s2.length();

        int[][] dp = new int[ind1 + 1][ind2 + 1];

        // Last column = 0
        for (int i = 0; i <= ind1; i++) {
            dp[i][ind2] = 0;
        }

        // Last row = 0
        for (int j = 0; j <= ind2; j++) {
            dp[ind1][j] = 0;
        }

        for (int i = ind1 - 1; i >= 0; i--) {
            for (int j = ind2 - 1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}