import java.util.*;

class Solution {

    class State {
        int x, y, parity;
        long cost;

        State(int x, int y, int parity, long cost) {
            this.x = x;
            this.y = y;
            this.parity = parity;
            this.cost = cost;
        }
    }

    public long minCost(int m, int n, int[][] penalty) {

        long[][][] dist = new long[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Long.MAX_VALUE);
            }
        }

        PriorityQueue<State> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        dist[0][0][1] = 1;
        pq.offer(new State(0, 0, 1, 1));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            State cur = pq.poll();

            if (cur.cost != dist[cur.x][cur.y][cur.parity])
                continue;

            if (cur.x == m - 1 && cur.y == n - 1)
                return cur.cost;

            int nextParity = 1 - cur.parity;

            long waitCost = cur.cost + penalty[cur.x][cur.y];
            if (waitCost < dist[cur.x][cur.y][nextParity]) {
                dist[cur.x][cur.y][nextParity] = waitCost;
                pq.offer(new State(cur.x, cur.y, nextParity, waitCost));
            }

            for (int d = 0; d < 4; d++) {

                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n){
                    continue;
                }
                long extra = 0;

                if (cur.parity == 1) {
                    
                    if (!(d == 1 || d == 3)){
                        extra = penalty[cur.x][cur.y];
                    }
                } else {
                    
                    if (!(d == 0 || d == 2)){
                        extra = penalty[cur.x][cur.y];
                    }
                }

                long newCost = cur.cost+ (long) (nx + 1) * (ny + 1)+ extra;

                if (newCost < dist[nx][ny][nextParity]) {
                    dist[nx][ny][nextParity] = newCost;
                    pq.offer(new State(nx, ny, nextParity, newCost));
                }
            }
        }

        return -1;
    }
}