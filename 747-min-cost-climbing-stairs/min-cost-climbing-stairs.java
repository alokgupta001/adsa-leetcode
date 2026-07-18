class Solution {
    Integer [] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new Integer[cost.length];
        return Math.min(solve(0,cost),solve(1,cost));
    }
    int solve(int i,int [] cost){
        if(i>=cost.length){
            return 0;
        }
        if(dp[i]!=null) return dp[i];
        int one = cost[i]+solve(i+1,cost);
        int two = cost[i]+solve(i+2,cost);
        return dp[i] = Math.min(one,two);
    }
}