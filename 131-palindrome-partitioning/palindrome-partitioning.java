class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dp = new Boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                solve(s,i,j);
            }
        }
        helper(0,s,new ArrayList<>());
        return res;

    }
    void helper(int idx,String s,List<String> temp){
        if(idx>=s.length()){
            int cnt = 0;
            for(String t : temp) cnt+=t.length();
            if(cnt==s.length())res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(dp[i][j]!=null && dp[i][j]==true){
                    temp.add(s.substring(i,j+1));
                    helper(j+1,s,temp);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    Boolean [][]dp;
    boolean solve(String s,int i,int j){
        if(i>=j) return dp[i][j]=true;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)!=s.charAt(j)) return dp[i][j]=false;
        return dp[i][j] = solve(s,i+1,j-1);
    }
}