class Solution {
    public int closedIsland(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vis[i][j]==0 && grid[i][j]==0){
                    if(dfs(grid,i,j, vis)) continue;
                    ans++;
                }
            }
        }
        return ans;
    }
    
    static boolean dfs(int[][]grid,int i,int j,int [][]vis){
        if(i>=grid.length || i<0 || j<0 || j>=grid[i].length) return true;
        if(grid[i][j]==1) return false;
        if(vis[i][j]==1) return false;
        vis[i][j]=1;
        boolean up=dfs(grid,i-1,j,vis);
        boolean down=dfs(grid,i,j-1,vis);
        boolean left =dfs(grid,i+1,j,vis);
        boolean right=dfs(grid,i,j+1,vis);
        return up||down||left||right;
    }
}