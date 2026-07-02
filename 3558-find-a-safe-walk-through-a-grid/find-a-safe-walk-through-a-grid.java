class Solution {
    int [] dir_r = {-1,1,0,0};
    int [] dir_c = {0,0,-1,1};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int [][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        dist[0][0] = health-grid.get(0).get(0);
        q.offer(new int[]{0,0,dist[0][0]});
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int rem = curr[2];
            if(row==m-1 && col==n-1 && rem>0){
                return true;
            }
            for(int k=0;k<4;k++){
                int nrow = row+dir_r[k];
                int ncol = col+dir_c[k];
                if(nrow>=0 && ncol>=0 && ncol<n && nrow<m && dist[nrow][ncol]<rem-grid.get(nrow).get(ncol) && (rem-grid.get(nrow).get(ncol))>0){
                    dist[nrow][ncol]=rem-grid.get(nrow).get(ncol);
                    q.offer(new int[]{nrow,ncol,rem-grid.get(nrow).get(ncol)});
                }
            }
        }
        return false;
    }
}