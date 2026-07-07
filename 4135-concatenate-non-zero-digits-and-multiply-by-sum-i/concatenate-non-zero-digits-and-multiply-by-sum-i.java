class Solution {
    public long sumAndMultiply(int n) {
        long ans = 0;
        long sum=0;
        while(n!=0){
            int digit = n%10;
            if(digit!=0){
                ans = ans*10;
                ans+=digit;
                sum+=digit;
            }
            n=n/10;
        }
        long num=0;
        while(ans!=0){
            num=num*10+ans%10;
            ans/=10;
        }
        return num*sum;
    }
    // String reverse(String s){
    //     StringBuilder sb = new StringBuilder(s);
    //     return sb.reverse().toString();
    // }
}