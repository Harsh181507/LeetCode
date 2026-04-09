class Solution {
    public int computerLPS(String s){
        int n = s.length();
        int [] lps = new int[n];

        int pref =0;
        int suff= 1;

        while(suff <n){
            if(s.charAt(pref) == s.charAt(suff)){
                pref++;
                lps[suff] = pref;
                suff++;
            }else{
                if(pref == 0){
                    lps[suff] =0;
                    suff++;
                }else{
                    pref = lps[pref-1];
                }
            }
        }
        return lps[n-1];
    }
    public String shortestPalindrome(String s) {
        int n = s.length();
        StringBuilder t = new StringBuilder(s).reverse();

        String x = s + "#" + t.toString();
        int j = computerLPS(x);
        StringBuilder ans = new StringBuilder();

        for (int i = n - 1; i >= j; i--) {
            ans.append(s.charAt(i));
        }

        ans.append(s);

        return ans.toString();
    }
}