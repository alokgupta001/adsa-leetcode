class Solution {
    Integer [][] dp;
    public boolean predictTheWinner(int[] nums) {
        dp = new Integer[nums.length][nums.length];
        return helper(nums,0,nums.length-1)>=0;
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