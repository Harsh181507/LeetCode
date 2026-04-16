class Solution {
    public double myPow(double x, int n) {
        long power = Math.abs((long) n);
        double ans = 1.0;

        while(power > 0){
            if(power %2 == 1){
                ans = ans * x;
                power = power-1;
            }else{
                power = power/2;
                x = x*x;
            }
        }
        return n > 0 ? ans : 1.0/ans;
    }
}