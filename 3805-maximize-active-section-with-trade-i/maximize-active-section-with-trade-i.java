class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int box1 = 0;
        int box2 = 0;
        int cnt1 = 0;
        int ans = 0;
        int i =0;
        while(i<n){
            if(s.charAt(i)=='0'){
                box1++;
                i++;
            }else{
                while(i<n && s.charAt(i)=='1'){
                    cnt1++;
                    i++;
                }
                while(i<n && s.charAt(i)=='0'){
                    box2++;
                    i++;
                }
                if(box1!=0 && box2!=0){
                    ans = Math.max(ans,box1+box2);
                }
                box1=box2;
                box2=0;
            }
        }
        return ans+cnt1;

    }
}