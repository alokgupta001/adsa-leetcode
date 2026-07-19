class Solution {
    public String smallestSubsequence(String s) {
        int [] freq = new int[26];
        boolean vis[]=new boolean[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        Stack<Character> st =  new Stack<>();
        for(char c:s.toCharArray()){
            freq[c-'a']--;
            if(vis[c-'a'])continue;
            while(!st.isEmpty() && st.peek()>c && freq[st.peek()-'a']>0){
                vis[st.pop()-'a']=false;
            }
            vis[c-'a']=true;
            st.push(c);
        }
        StringBuilder sb =new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}