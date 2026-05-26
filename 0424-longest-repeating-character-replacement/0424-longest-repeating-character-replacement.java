class Solution {
    public int characterReplacement(String s, int k) {
        int low = 0;
        
        int res = Integer.MIN_VALUE;
        int [] freq = new int [256];
        
        for(int high = 0; high <s.length(); high++){
            char ch = s.charAt(high);
            freq[ch]++;
            int len = high - low + 1;
            int maxcount = find(freq);
            int diff = len - maxcount;

            while(diff > k){
                char leftchar = s.charAt(low);
                freq[leftchar]--;
                low++;

                maxcount = find(freq);
                len = high - low +1;
                diff = len - maxcount;
            }
            len = high - low + 1;
            res = Math.max(res, len);
        }
        return res;
    }
    public static int find(int [] freq){
        int maxi=0;
        for(int i=0; i<freq.length; i++){
            maxi = Math.max(maxi, freq[i]);
        }
        return maxi;
    }
}