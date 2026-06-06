class Solution {
    public int findMaximizedCapital(int k, int w,int[] profits,int[] capital) {

        int n = profits.length;

        List<int[]> proj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            proj.add(new int[]{capital[i], profits[i]});
        }

        Collections.sort(proj, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;

        while(k-- > 0){

            while(idx < n && proj.get(idx)[0] <= w){
                pq.add(proj.get(idx)[1]);
                idx++;
            }

            if(pq.isEmpty()){
                return w;
            }

            w += pq.poll();
        }

        return w;
    }
}