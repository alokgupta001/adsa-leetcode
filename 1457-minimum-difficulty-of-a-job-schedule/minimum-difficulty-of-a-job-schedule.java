class Solution {
    int[][] dp;
    int solve(int[] jobs, int i, int days) {
        int n = jobs.length;
        if (days == 1) {
            int max = 0;
            for (int j = i; j < n; j++)
                max = Math.max(max, jobs[j]);
            return max;
        }
        if (dp[i][days] != -1) return dp[i][days];
        int ans = Integer.MAX_VALUE;
        int max = 0;
        for (int j = i; j <= n - days; j++) {

            max = Math.max(max, jobs[j]);

            int remaining =
                solve(jobs, j + 1, days - 1);

            ans = Math.min(ans, max + remaining);
        }

        return dp[i][days] = ans;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {

        int n = jobDifficulty.length;

        if (n < d)
            return -1;

        dp = new int[n][d + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(jobDifficulty, 0, d);
    }
}