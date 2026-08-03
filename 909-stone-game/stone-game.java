class Solution {
    Integer [][] dp;
    public boolean stoneGame(int[] piles) {
        dp = new Integer[piles.length][piles.length];
        return helper(piles,0,piles.length-1)>=0;
    }
    int helper(int[]nums,int i,int j){
        if(i==j){
            return nums[i];
        }
        if(dp[i][j]!=null)return dp[i][j];
        int leftPick = nums[i] - helper(nums,i+1,j);
        int rightPick = nums[j] - helper(nums,i,j-1);
        return dp[i][j]= Math.max(leftPick,rightPick);
    }
}