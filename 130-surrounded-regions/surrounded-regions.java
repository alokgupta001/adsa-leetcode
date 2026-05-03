class Solution {
    public void solve(char[][] board) {
        int[][] vis = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    if(dfs(board,i,j, vis)) continue;
                    dfs1(board,i,j); 
                }
            }
        }
    }
    static void dfs1(char[][]board,int i,int j){
        if(i>=board.length || i<0 || j<0 || j>=board[i].length) return;
        if(board[i][j]=='X') return;
        board[i][j]='X';
        dfs1(board,i-1,j);
        dfs1(board,i,j-1);
        dfs1(board,i+1,j);
        dfs1(board,i,j+1);
        return;
    }
    static boolean dfs(char[][]board,int i,int j,int [][]vis){
        if(i>=board.length || i<0 || j<0 || j>=board[i].length) return true;
        if(board[i][j]=='X') return false;
        if(vis[i][j]==1) return false;
        vis[i][j]=1;
        boolean up=dfs(board,i-1,j,vis);
        boolean down=dfs(board,i,j-1,vis);
        boolean left =dfs(board,i+1,j,vis);
        boolean right=dfs(board,i,j+1,vis);
        return up||down||left||right;
    }
}