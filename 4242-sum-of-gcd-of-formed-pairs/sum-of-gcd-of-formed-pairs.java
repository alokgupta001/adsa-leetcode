class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int [] prefix = new int[n];
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            prefix[i] = gcd(nums[i],max);
        }
        Arrays.sort(prefix);
        int i=0;
        int j= n-1;
        long ans = 0;
        while(true){
            if(i==j) break;
            if(i>j) break;
            ans=ans + (long)gcd(prefix[i],prefix[j]);
            i++;
            j--;
        }
        return ans;

    }
    int gcd(int a,int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}