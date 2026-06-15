class Pair{
    int first;
    int second;
    int third;

    Pair(int f,int s,int t){
        first = f;
        second = s;
        third = t;
    }
}

class Solution {

    int[] x = {1,-1,0,0};
    int[] y = {0,0,1,-1};

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        int[][] res = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>(
                (a,b) -> a.first - b.first
            );

        res[0][0] = grid[0][0];

        pq.add(
            new Pair(
                grid[0][0],
                0,
                0
            )
        );

        while(!pq.isEmpty()){

            Pair p = pq.poll();

            int dist = p.first;
            int row = p.second;
            int col = p.third;

            if(dist > res[row][col]){
                continue;
            }

            for(int k = 0; k < 4; k++){

                int r = row + x[k];
                int c = col + y[k];

                if(!valid(r,c,n,n)){
                    continue;
                }

                int newwt =
                    Math.max(
                        dist,
                        grid[r][c]
                    );

                if(newwt < res[r][c]){

                    res[r][c] = newwt;

                    pq.add(
                        new Pair(
                            newwt,
                            r,
                            c
                        )
                    );
                }
            }
        }

        return res[n-1][n-1];
    }

    public boolean valid(int i,int j,int n,int m){

        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }

        return true;
    }
}