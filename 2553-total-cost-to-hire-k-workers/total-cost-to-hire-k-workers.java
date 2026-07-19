class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int left = 0;
        int right = n - 1;

        // 0 -> left, 1 -> right
        for (int i = 0; i < candidates && left <= right; i++) {
            pq.offer(new int[]{costs[left], left, 0});
            left++;
        }

        for (int i = 0; i < candidates && left <= right; i++) {
            pq.offer(new int[]{costs[right], right, 1});
            right--;
        }

        long ans = 0;

        while (!pq.isEmpty() && k > 0) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int dir = curr[2];

            ans += cost;

            if (dir == 0) {
                if (left <= right) {
                    pq.offer(new int[]{costs[left], left, 0});
                    left++;
                }
            } else {
                if (left <= right) {
                    pq.offer(new int[]{costs[right], right, 1});
                    right--;
                }
            }

            k--;
        }

        return ans;
    }
}