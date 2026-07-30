class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int [] freq = new int[26];
        
        for(int i=0;i<n/2;i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        //Arrays.sort(freq);
        for(int i=0;i<26;i++){
            for(int j=0;j<freq[i];j++){
                sb.append( (char)('a'+i));
            }
        }
        if(n%2!=0){
            return new String(sb.toString()+s.charAt(n/2)+sb.reverse().toString());
        }
        return new String(sb.toString()+sb.reverse().toString());
        
    }
}