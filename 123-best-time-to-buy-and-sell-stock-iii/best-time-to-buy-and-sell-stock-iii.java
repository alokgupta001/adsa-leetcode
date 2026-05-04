class Solution {
    Integer [][][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2][3];
        return solve(0,0,2,prices);
    }
    int solve(int i,int canBuy,int t,int[] prices){
        if(t==0){
            return 0;
        }
        if(i==prices.length) return 0;
        if(dp[i][canBuy][t]!=null) return dp[i][canBuy][t];
        if(canBuy==0){
            int nottake = solve(i+1,0,t,prices);
            int take = -prices[i]+ solve(i+1,1,t,prices);
            return dp[i][canBuy][t]=Math.max(take,nottake);
        }else{
            int notsell = solve(i+1,canBuy,t,prices);
            int sell = prices[i] + solve(i+1,0,t-1,prices);
            return dp[i][canBuy][t]= Math.max(sell,notsell);
        }
    }
}