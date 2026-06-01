class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        HashMap<Character, Integer> freq = new HashMap<>();

        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(freq.get(ch) == 1){
                return i;
            }
        }
        return -1;
    }
}