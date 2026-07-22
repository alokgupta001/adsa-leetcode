class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int [] dp = new int[nums.length];
        int [] hash = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(hash,-1);
        int maxi=1;
        int last=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<1+dp[j]){
                    dp[i] = 1+dp[j];
                    hash[i] = j;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                last=i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        
        while(last!=-1){
            ans.add(nums[last]);
            last = hash[last];
        }
        Collections.reverse(ans);
        return ans;
    }
}