class Solution {
    

    public int numDecodings(String s) {
        Integer [] dp = new Integer[s.length()];
        return solve(s,0,dp);
    }
    int solve(String s,int index,Integer []dp){
        if(index==s.length()) return 1;
        if(dp[index]!=null) return dp[index];
        if(s.charAt(index)=='0'){
            return dp[index] =0;
        }
        int ways = solve(s,index+1,dp);
        if(index+1<s.length() && Integer.parseInt(s.substring(index,index+2))<=26){
            ways = ways + solve(s,index+2,dp);
        }
        return dp[index] = ways;
    }
}