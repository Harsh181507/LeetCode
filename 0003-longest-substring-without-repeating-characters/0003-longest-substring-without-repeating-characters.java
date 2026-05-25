class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int high =0;
        int res = 0;
        HashMap <Character,Integer> freq = new HashMap<>();
        for(high = 0; high<s.length(); high++){
            char ch = s.charAt(high);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);          
            
            while (freq.get(ch) > 1) {

                char leftChar = s.charAt(low);

                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }

                low++;
            }

            int len = high - low + 1;

            res = Math.max(res, len);
        }

        return res;
    }
}