class Solution {
    int [] dp;
    public int maxJumps(int[] arr, int d) {
        Queue<int[]> q = new LinkedList<>();
        int ans = 1;
        dp = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans = Math.max(ans,dfs(arr,d,i));
        }
        return ans;
    }
    int dfs(int[] arr,int d,int idx){
        if (dp[idx] != 0) {
            return dp[idx];
        }
        int best = 1;
        for (int i = idx + 1; i <= Math.min(arr.length - 1, idx + d); i++) {
            if (arr[i] >= arr[idx]) {
                break;
            }
            best = Math.max(best, 1 + dfs(arr, d, i));
        }
        for (int i = idx - 1; i >= Math.max(0, idx - d); i--) {
            if (arr[i] >= arr[idx]) {
                break;
            }
            best = Math.max(best, 1 + dfs(arr, d, i));
        }
        return dp[idx] = best;
    }
}