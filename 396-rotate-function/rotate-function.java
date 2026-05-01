class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f = 0;
        for (int i = 0; i < n; i++){
            sum += nums[i];
            f += i*nums[i];
        }
        int max = f;
        for (int j = 1; j < n; j++){
            f = f + sum - n*nums[n-j];
            max = Math.max(max, f);
        }
        return max;
    }
}