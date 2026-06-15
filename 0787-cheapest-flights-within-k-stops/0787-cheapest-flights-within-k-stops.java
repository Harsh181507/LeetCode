class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] res = new int[n];
        Arrays.fill(res,(int)1e8);
        res[src] = 0;
        for(int i = 0; i <= k; i++){
            int[] temp = res.clone();
            for(int j = 0; j < flights.length; j++){
                int s = flights[j][0];
                int d = flights[j][1];
                int w = flights[j][2];
                if(res[s] != (int)1e8 && temp[d] > res[s] + w){
                    temp[d] = res[s] + w;
                }
            }
            res = temp;
        }
        if(res[dst] == (int)1e8){
            return -1;
        }
        return res[dst];
    }
}