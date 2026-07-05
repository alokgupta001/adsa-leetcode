class Solution {
    int m,n;
    Integer [][] dp;
    public int countSquares(int[][] matrix) {
        m = matrix.length;
        n= matrix[0].length;
        int ans = 0;
        dp = new Integer[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans += solve(i,j,matrix);
            }
        }
        return ans;
    }
    int solve(int i,int j,int [][] matrix){
        if(i>=m || j>=n || matrix[i][j]==0){
            return 0;
        }
        if(dp[i][j]!=null) return dp[i][j];
        return dp[i][j] = 1+Math.min(solve(i+1,j+1,matrix),Math.min(solve(i+1,j,matrix),solve(i,j+1,matrix)));
    }
}