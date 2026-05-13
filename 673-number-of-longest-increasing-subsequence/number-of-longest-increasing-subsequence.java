class Solution {
    public int findNumberOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        int [] hash = new int[nums.length];
        int [] lis = new int[nums.length];
        int max=1;
        int last = -1;
        Arrays.fill(dp,1);
        Arrays.fill(hash,-1);
        Arrays.fill(lis,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] ){
                    if(dp[j]+1>dp[i]){
                        dp[i]=1+dp[j];
                        hash[i]=j;
                        lis[i]=lis[j];
                    }else if(dp[j]+1==dp[i]){
                        lis[i]+=lis[j];
                    }
                }
                
            }
            if(dp[i]>max){
                max = dp[i];
                last = i;
            }
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]==max) ans+=lis[i];
        }
        return ans;
    }
}