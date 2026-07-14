class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1;
        int right =0;
        for(int p:piles){
            right = Math.max(p,right);
        }
        int ans =0;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isValid(piles,h,mid)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    boolean isValid(int [] piles,int h,int k){
        int time =0;
        for(int pile :piles){
            time += pile/k;
            if(pile%k!=0)time++;
            if(time>h) return false;
        }
        return time<=h;
    }
}