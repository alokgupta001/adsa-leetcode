class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int[][] vis1 = new int[grid.length][grid[0].length];
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    if(dfs(grid,i,j, vis)) continue;
                    ans+=dfs1(grid,i,j,vis1); 
                }
            }
        }
        return ans;
    }
    static int dfs1(int[][]grid,int i,int j,int [][]vis){
        if(i>=grid.length || i<0 || j<0 || j>=grid[i].length) return 0;
        if(grid[i][j]==0) return 0;
        if(vis[i][j]==1) return 0;
        int area = 1;
        vis[i][j]=1;
        area = area +dfs1(grid,i-1,j,vis);
        area = area +dfs1(grid,i,j-1,vis);
        area = area +dfs1(grid,i+1,j,vis);
        area = area +dfs1(grid,i,j+1,vis);
        return area;
    }
    static boolean dfs(int[][]grid,int i,int j,int [][]vis){
        if(i>=grid.length || i<0 || j<0 || j>=grid[i].length) return true;
        if(grid[i][j]==0) return false;
        if(vis[i][j]==1) return false;
        vis[i][j]=1;
        boolean up=dfs(grid,i-1,j,vis);
        boolean down=dfs(grid,i,j-1,vis);
        boolean left =dfs(grid,i+1,j,vis);
        boolean right=dfs(grid,i,j+1,vis);
        return up||down||left||right;
    }
}