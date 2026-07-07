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
        ans = Long.parseLong(reverse(Long.toString(ans)));
        return ans*sum;
    }
    String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}