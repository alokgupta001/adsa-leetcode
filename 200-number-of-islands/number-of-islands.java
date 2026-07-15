class Solution {
    public int numIslands(char[][] grid) {
        int cnt=0;
        int[][] vis = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    dfs(grid,i,j, vis);
                }
            }
        }
        return cnt;
    }
    void dfs(char[][]grid,int i,int j,int [][]vis){
        if(i>=grid.length || i<0 || j<0 || j>=grid[i].length) return;
        if(grid[i][j]=='0') return;
        if(vis[i][j]==1) return;
        vis[i][j]=1;
        dfs(grid,i-1,j,vis);
        dfs(grid,i,j-1,vis);
        dfs(grid,i+1,j,vis);
        dfs(grid,i,j+1,vis);
        return;
    }
}