class Solution {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        // HashMap<String,Integer> map = new HashMap<>();
        int [][] trim = new int[n][n];
        for(int i=0;i<n;i++){
            int [] freq = new int[n]; 
            int curr=0;
            for(int j=i;j<n;j++){
                freq[nums[j]]++;
                if(freq[nums[j]]==2){
                    curr+=2;
                }else if(freq[nums[j]]>2){
                    curr++;
                }
                //String key = i+"#"+j;
                //map.put(key,curr);
                trim[i][j]=curr;
            }
        }
        dp =new Integer[n];
        int ans = solve(nums,0,n-1,trim,k);
        return ans;
    }
    Integer [] dp;
    int solve(int [] nums,int start,int end,int [][] trim,int k){
        if(start>end) return 0;
        if(dp[start]!=null) return dp[start];
        int min = Integer.MAX_VALUE;
        for(int idx=start;idx<=end;idx++){
            //String key = start+"#"+idx;
            int cost = k+trim[start][idx]+solve(nums,idx+1,end,trim,k);
            min = Math.min(min,cost);
        }
        return dp[start]=min;
    }
}