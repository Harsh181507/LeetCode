class Pair{
    int first;
    int second;
    Pair(int f, int s){
        first = f;
        second = s;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            a.add(new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++){
            int s = times[i][0];
            int d = times[i][1];
            int w = times[i][2];
            a.get(s - 1).add(new Pair(d - 1, w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x,y) -> x.first - y.first
        );
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;
        pq.add(new Pair(0, k - 1));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int d = p.first;
            int node = p.second;
            if(d > dist[node]){
                continue;
            }
            for(int j = 0; j < a.get(node).size(); j++){
                int neighbour = a.get(node).get(j).first;
                int wt = a.get(node).get(j).second;
                if(d + wt < dist[neighbour]){
                    dist[neighbour] = d + wt;
                    pq.add(new Pair(dist[neighbour], neighbour));
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}