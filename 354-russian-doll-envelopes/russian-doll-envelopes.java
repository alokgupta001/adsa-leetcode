class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)-> a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]);
        int[] height = new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            height[i]= envelopes[i][1];
        }
        return LIS(height);
    }
    public int LIS(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(nums[0]);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>l1.get(l1.size()-1)){
                l1.add(nums[i]);
            }else{
                l1.set(lowerBound(l1,nums[i]),nums[i]);
            }
        }
        return l1.size();
    }
    int lowerBound(List<Integer> l1 ,int target){
        int left=0;
        int right = l1.size();
        while(left<=right){
            int mid = left+(right-left)/2;
            if(l1.get(mid)<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}