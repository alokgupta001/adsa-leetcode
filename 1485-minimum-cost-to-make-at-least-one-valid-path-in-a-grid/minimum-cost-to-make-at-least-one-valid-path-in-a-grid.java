class Solution {
    int [] dir_r = {0,0,1,-1};
    int [] dir_c = {1,-1,0,0};
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        cost[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currCost = current[0];
            int i = current[1];
            int j = current[2];

            if (i == m - 1 && j == n - 1) {
                return currCost;
            }

            for (int k = 0; k < 4; k++) {
                int ni = i + dir_r[k];
                int nj = j + dir_c[k];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    int newCost = (grid[i][j] == k + 1) ? currCost : currCost + 1;

                    if (newCost < cost[ni][nj]) {
                        cost[ni][nj] = newCost;
                        pq.offer(new int[]{newCost, ni, nj});
                    }
                }
            }
        }

        return cost[m - 1][n - 1];
    }
    
}