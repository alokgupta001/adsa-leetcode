class Solution {
    public int minimumPushes(String word) {
        int [] freq = new int[26];
        for(char c:word.toCharArray()){
            freq[c-'a']++;
        }
        Arrays.sort(freq);
        int ans=0;
        int buttonUsed = 0;
        for(int i=25;i>=0;i--){
            if(freq[i]!=0 && buttonUsed<8){
                ans = ans+freq[i];
                buttonUsed++;
            }else if(freq[i]!=0 && buttonUsed<16){
                ans = ans+(freq[i]*2);
                buttonUsed++;
            }else if(freq[i]!=0 && buttonUsed<24){
                ans = ans+(freq[i]*3);
                buttonUsed++;
            }else if(freq[i]!=0 && buttonUsed<32){
                ans = ans+(freq[i]*4);
                buttonUsed++;
            }
        }
        return ans;
    }
}