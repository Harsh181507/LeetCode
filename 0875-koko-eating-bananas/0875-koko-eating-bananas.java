class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        for(int i = 0; i<piles.length;i++){
            end = Math.max(end,piles[i]);
        }
        int res = -1;

        while(start <= end){
            int mid = start +(end - start)/2;
            long hour = hours(piles,h,mid);
            if(hour > h){
                start = mid + 1;
            }else{
                res = mid;
                end = mid - 1;
            }
        }
        return res;
    }
    public long hours(int[] piles, int h, int speed){
        long c =0;
        for(int i=0;i<piles.length;i++){
            c = c + piles[i] / speed;
            if(piles[i] % speed != 0){
                c++;
            }
        }
        return c;
    }

}