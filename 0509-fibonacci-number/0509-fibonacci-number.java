class Solution {
    HashMap<Integer,Integer> dp = new HashMap<>();
    public int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        int ans = fib(n - 1) + fib(n - 2);
        dp.put(n, ans);
        return ans;
    }
}