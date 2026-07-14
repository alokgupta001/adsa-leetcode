class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        for(int i=0;i<n;i++){
            left = Math.max(left,nums[i]);
            right+=nums[i];
        }
        int ans = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(solve(nums,k,mid)){
                ans = mid;
                right=mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    boolean solve(int []nums,int k,int maxSum){
        int sum =0;
        int cnt =1; //full array is a subarray
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>maxSum){
                cnt++;
                sum = nums[i];
            }
            if(cnt>k) return false;
        }
        if(cnt>k) return false;
        return true;
        
    }
    
}