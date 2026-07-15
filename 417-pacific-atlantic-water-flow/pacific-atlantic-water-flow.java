class Solution {
    int m,n;
    int [] dir_r = {1,-1,0,0};
    int [] dir_c = {0,0,-1,1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean [][] atlantic = new boolean[m][n];
        boolean [][] pacific = new boolean[m][n];
        for(int i=0;i<n;i++){
            if(!pacific[0][i]){
                dfs(0,i,heights,pacific);
            }
            if(!atlantic[m-1][i]){
                dfs(m-1,i,heights,atlantic);
            }
        }
        for(int i=0;i<m;i++){
            if(!pacific[i][0]){
                dfs(i,0,heights,pacific);
            }
            if(!atlantic[i][n-1]){
                dfs(i,n-1,heights,atlantic);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(atlantic[i][j]&& pacific[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    void dfs(int i,int j,int [][] grid,boolean [][] visited){
        visited[i][j]= true;
        for(int k=0;k<4;k++){
            int nrow = i+dir_r[k];
            int ncol = j+dir_c[k];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && !visited[nrow][ncol] && grid[nrow][ncol]>=grid[i][j]){
                dfs(nrow,ncol,grid,visited);
            }
        }
        return;
    }
}