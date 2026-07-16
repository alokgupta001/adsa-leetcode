class Solution {

    int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1){
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        q.offer(new int[]{0, 0, 1});
        vis[0][0] = true;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if (r == m - 1 && c == n - 1) return dist;
            for (int k = 0; k < 8; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 0 &&
                    !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
}