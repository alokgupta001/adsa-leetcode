class Solution {
    int [] dir_r = {-1,1,0,0};
    int [] dir_c = {0,0,-1,1};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.offer(new int[]{0,0,grid[0][0]});
        int [][] dis = new int [n][n];
        for(int [] row:dis){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dis[0][0] = grid[0][0];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int row =curr[0];
            int col = curr[1];
            int d = curr[2];
            if(row==n-1 && col==n-1) return d;
            if(d>dis[row][col]) continue;
            for(int k=0;k<4;k++){
                int nrow = row+dir_r[k];
                int ncol = col +dir_c[k];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<n){
                    int nd = Math.max(d,grid[nrow][ncol]);
                    if(nd<dis[nrow][ncol]){
                        dis[nrow][ncol] = nd;
                        pq.offer(new int []{nrow,ncol,nd});
                    }
                }
            }
        }
        return 0;
    }
}