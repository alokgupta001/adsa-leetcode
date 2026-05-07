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
    void helper(int start,String s,List<String> temp){
        if(start == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<s.length();i++){
            String part=s.substring(start,i+1);
            if(dp[start][i]!=null && dp[start][i]==true){
                temp.add(part);
                helper(i+1,s,temp);
                temp.remove(temp.size()-1);
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