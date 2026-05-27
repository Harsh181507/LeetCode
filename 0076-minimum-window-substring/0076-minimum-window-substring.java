class Solution {
    public String minWindow(String s, String t) {
        int [] have = new int[256];
        int [] needed = new int[256];
        int low =0;
        int res = Integer.MAX_VALUE;
        int n = s.length();
        int start =0;
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            needed[ch]++;
        }

        for(int high = 0; high < n;high++){
            char highch = s.charAt(high);
            have[highch]++;

            while(correct(have,needed)){
                int len = high - low+1;
                if(res > len){
                    res = len;
                    start = low;
                }
                have[s.charAt(low)]--;
                low++;
            }
        }
        if (res == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + res);
    }
    public static boolean correct (int [] have, int [] needed){
        for(int i =0; i<256;i++){
            if(have[i] < needed [i]){
                return false;
            }
        }
        return true;
    }
}