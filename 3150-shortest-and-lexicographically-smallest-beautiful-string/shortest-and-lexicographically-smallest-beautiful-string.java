class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int one = 0;
        int i = 0;
        List<String> ans = new ArrayList<>();
        int maxLen = Integer.MAX_VALUE;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='1') one++;
            while(one>=k && i<=j){
                int currLen = j-i+1;
                if(currLen<maxLen) {
                    maxLen = currLen;
                    ans.clear();
                    ans.add(s.substring(i,j+1));
                }
                else if(currLen==maxLen){
                    ans.add(s.substring(i,j+1));
                }
                if(s.charAt(i)=='1'){
                    one--;
                }
                i++;
            }
        }
        Collections.sort(ans);
        return ans.size()>0?ans.get(0):"";
    }
}