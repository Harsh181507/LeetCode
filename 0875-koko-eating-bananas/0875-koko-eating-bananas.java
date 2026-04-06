class Solution {
    
    public boolean canEatAll(int[] piles, int mid, int h) {
        int actualHour = 0;
        
        for (int i : piles) {
            actualHour += i / mid;
            
            if (i % mid != 0) {
                actualHour++;
            }
        }
        
        return actualHour <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1;
        int r = 0;

        for (int i : piles) {
            r = Math.max(r, i);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (canEatAll(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}