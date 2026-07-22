class Solution {
    List<Integer> [] memo;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        memo = new ArrayList[nums.length];
        for(int i = 0;i<nums.length;i++){
            List<Integer> curr = solve(nums,i);
            if(curr.size()>ans.size()){
                ans = new ArrayList<>(curr);
            }
        }
        return ans;
    }
    List<Integer> solve (int []nums,int i){
        if(memo[i]!=null) return memo[i];
        List<Integer> best = new ArrayList<>();
        best.add(nums[i]);
        for(int j=0;j<i;j++){
            if(nums[i]%nums[j]==0){
                List<Integer> curr = solve(nums,j);
                if(1+curr.size()>best.size()){
                    best = new ArrayList<>(curr);
                    best.add(nums[i]);
                }
            }
        }
        return memo[i]= best;
    }
}