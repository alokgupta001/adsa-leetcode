class Solution {
    Integer [] dp;
    public int climbStairs(int n, int[] costs) {
        dp = new Integer[n];
        return solve(0,n,costs);
    }
    int solve(int i,int n,int [] costs){
        if(i==n) return 0;
        if(i>n) return Integer.MAX_VALUE;
        if(dp[i]!=null) return dp[i];
        int one = costs[i+1-1]+1 +solve(i+1,n,costs);
        int two = Integer.MAX_VALUE;
        if(i+2-1<n)two = costs[i+2-1]+4 + solve(i+2,n,costs);
        int three = Integer.MAX_VALUE;
        if(i+3-1<n)three = costs[i+3-1]+9 + solve(i+3,n,costs);
        return dp[i]= Math.min(one,Math.min(two,three));
    }
}