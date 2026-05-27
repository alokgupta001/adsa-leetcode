class Solution {
    public int numberOfSpecialChars(String word) {
        int [] freq = new int[26];
        int [] ans = new int [26];
        boolean [] isValid = new boolean[26];
        int cnt =0;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(Character.isUpperCase(c)){
                //char nc = 
                if(freq[c+32-'a']==0) isValid[c+32-'a']=true;
                if(freq[c+32-'a']!=0){
                    if(!isValid[c+32-'a']) ans[c+32-'a']=1;
                }
            }else{
                freq[c-'a']++;
                if(ans[c-'a']!=0){
                    ans[c-'a']=0;
                    isValid[c-'a']=true;
                }
            }
        }
        for(int i=0;i<26;i++){
            if(!isValid[i] && ans[i]!=0)cnt++;
        }
        return cnt;
    }
}