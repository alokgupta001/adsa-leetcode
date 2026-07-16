class Solution {
    int m,n;
    int [] dir_r={-1,1,0,0};
    int [] dir_c={0,0,-1,1};
    int INF = (int)1e9+1;
    public int maximumMinutes(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        m=grid.length;
        n=grid[0].length;
        int [][] dist = new int[m][n];
        for(int[] row:dist){
            Arrays.fill(row,INF);
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{i,j,0});
                    dist[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            int row= q.peek()[0];
            int col = q.peek()[1];
            int d = q.peek()[2];
            q.poll();
            for(int k=0;k<4;k++){
                int nrow = row+dir_r[k];
                int ncol = col+dir_c[k];
                int nd = d+1;
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]!=2&& nd<dist[nrow][ncol]){
                    dist[nrow][ncol]=nd;
                    q.offer(new int[]{nrow,ncol,nd});
                }
            }
        }
        q.clear();
        if(canReach(grid,dist)) return INF-1;
        int stayedL=0;
        int stayedR = dist[m-1][n-1];
        int ans = -1;
        while(stayedL<=stayedR){
            boolean reached =false;
            boolean [][] vis = new boolean[m][n];
            q.clear();
            vis[0][0]=true;
            int mid = stayedL+(stayedR-stayedL)/2;
            if (mid >= dist[0][0]) {
                stayedR = mid - 1;
                continue;
            }
            q.offer(new int[]{0,0,mid});
            while(!q.isEmpty()){
                int row= q.peek()[0];
                int col = q.peek()[1];
                int d = q.peek()[2];
                q.poll();
                if(row==m-1 && col == n-1){
                    reached =true;
                    q.clear();
                    break;
                }
                for(int k=0;k<4;k++){
                    int nrow = row+dir_r[k];
                    int ncol = col+dir_c[k];
                    int nd = d+1;
                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]!=2  && !vis[nrow][ncol]){
                        if(nrow==m-1 && ncol==n-1&& nd<=dist[nrow][ncol]){
                            q.offer(new int[]{nrow,ncol,nd});
                        }
                        else if(nd<dist[nrow][ncol]){
                            q.offer(new int[]{nrow,ncol,nd});
                        }
                        vis[nrow][ncol]=true;
                    }
                }
            }
            if(reached){
                ans = mid;
                stayedL=mid+1;
            }else{
                stayedR=mid-1;
            }
        }
        if(INF-1-ans<=m*n) return INF-1;
        return ans;
    }
    boolean canReach(int[][] grid,int [][]dist){
        boolean [][]vis= new boolean[m][n];
        boolean reached = false;
        vis[0][0]=true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,INF-1});
        while(!q.isEmpty()){
            int row= q.peek()[0];
            int col = q.peek()[1];
            int d = q.peek()[2];
            q.poll();
            if(row==m-1 && col == n-1){
                reached =true;
                q.clear();
                break;
            }
            for(int k=0;k<4;k++){
                int nrow = row+dir_r[k];
                int ncol = col+dir_c[k];
                int nd = d+1;
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]!=2  && !vis[nrow][ncol]){
                    if(nrow==m-1 && ncol==n-1&& nd<=dist[nrow][ncol]){
                        q.offer(new int[]{nrow,ncol,nd});
                    }
                    else if(nd<dist[nrow][ncol]){
                        q.offer(new int[]{nrow,ncol,nd});
                    }
                    vis[nrow][ncol]=true;
                }
            }
        }
        return reached;

    }
}