class Solution {
    public int maxProduct(int n) {
        String s = Integer.toString(n);
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int idx_a = -1;
        int idx_b = -1;
        for(int i=0;i<s.length();i++){
            int curr = s.charAt(i)-'0';
            if(curr>a){
                a = curr;
                idx_a = i;
            }
        }
        for(int i=0;i<s.length();i++){
            int curr = s.charAt(i)-'0';
            if(curr>b && idx_a!=i){
                b = curr;
                idx_b = i;
            }
        }
        return a*b;
    }
}