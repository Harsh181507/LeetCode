import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int f, int s) {
        first = f;
        second = s;
    }
}

class Solution {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a.first != b.first)
                    return b.first - a.first;   // Max on distance

                return b.second - a.second;     // Max on index
            }
        );

        for(int i = 0; i < points.length; i++) {

            int x = points[i][0];
            int y = points[i][1];

            int dist = x * x + y * y;

            Pair curr = new Pair(dist, i);

            if(pq.size() < k) {
                pq.add(curr);
                continue;
            }

            if(curr.first < pq.peek().first) {
                pq.poll();
                pq.add(curr);
            }
        }

        int[][] res = new int[k][2];

        int idx = 0;

        while(!pq.isEmpty()) {

            int pointIndex = pq.poll().second;

            res[idx][0] = points[pointIndex][0];
            res[idx][1] = points[pointIndex][1];

            idx++;
        }

        return res;
    }
}