class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        dp=new Integer[s.length()][t.length()];
        return solve(s,t,s.length()-1,t.length()-1);
    }
    int solve(String s,String t,int i,int j){
        
        if(j<0)return 1;
        if(i<0)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=solve(s,t,i-1,j-1)+solve(s,t,i-1,j);
        }
        return dp[i][j]=solve(s,t,i-1,j);
    }
}