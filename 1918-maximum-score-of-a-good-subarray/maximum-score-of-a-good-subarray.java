class Solution {
    public int maximumScore(int[] nums, int k) {
        int max = nums[k];
        int min = nums[k];
        int i=k;
        int j=k;
        while(i>0 || j<nums.length-1){
            if(i==0){
                ++j;
            }
            else if(j==nums.length-1) --i;
            else if(nums[i-1]>nums[j+1]){
                
                --i;
            }else{    
                ++j;
            }
            min = Math.min(nums[j],Math.min(min,nums[i]));
            max = Math.max(max,min*(j-i+1));
            
        }
        return max;
    }
}