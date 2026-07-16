class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        List<int[]> sources = new ArrayList<>();
        int oranges = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0)oranges++;
                if(grid[i][j]==2){
                    sources.add(new int[]{i,j});
                }
            }
        }
        int ans = bfs(grid,sources,vis);
        if(cnt==oranges) return ans;
        return -1;
    }
    static int [] dir_r = {-1,1,0,0};
    static int [] dir_c = {0,0,-1,1};
    int time = 0;
    int max = 0;
    int cnt=0;
    int bfs(int[][] grid,List<int[]> sources,int [][] vis){

        Queue<int[]> q = new LinkedList<>();
        for(int [] sr : sources){
            q.offer(new int[]{sr[0],sr[1],0});
            cnt++;
            vis[sr[0]][sr[1]]=1;
        }
        while(!q.isEmpty()){
            int row = q.peek()[0]; 
            int col = q.peek()[1];
            int d = q.peek()[2];
            q.poll();
            for(int m=0;m<4;m++){
                int nrow = row + dir_r[m];
                int ncol = col +dir_c[m];
                int nd = d+1;

                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.offer(new int[]{nrow,ncol,nd});
                    vis[nrow][ncol] =  1;
                    cnt++;
                }
            }
            time = Math.max(time,d);
        }
        return time;
    }
}