class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd = n*n;
        int even  = n*(n+1);
        return gcd(odd,even);
    }
    int gcd(int a,int b){
        while(b!=0){
            int t = a%b;
            a = b;
            b= t;
        }
        return a;
    }
}