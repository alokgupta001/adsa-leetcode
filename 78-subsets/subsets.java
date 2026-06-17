class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,nums,0,new ArrayList<>());
        return res;
    }
    void backtrack(List<List<Integer>> res, int[] nums, int i,List<Integer> l1){
        res.add(new ArrayList<>(l1));
        for(int j =i;j<nums.length;j++){
            l1.add(nums[j]);
            backtrack(res,nums,j+1,l1);
            l1.remove(l1.size()-1); 
        }
    }
}