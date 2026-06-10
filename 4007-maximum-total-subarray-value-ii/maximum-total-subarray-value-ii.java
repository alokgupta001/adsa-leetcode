class SegmentTree {

    int n;
    int[] minTree;
    int[] maxTree;

    public SegmentTree(int[] nums) {
        n = nums.length;
        minTree = new int[4 * n];
        maxTree = new int[4 * n];

        build(0, 0, n - 1, nums);
    }

    private void build(int idx, int l, int r, int[] nums) {
        if (l == r) {
            minTree[idx] = nums[l];
            maxTree[idx] = nums[l];
            return;
        }

        int mid = l + (r - l) / 2;

        build(2 * idx + 1, l, mid, nums);
        build(2 * idx + 2, mid + 1, r, nums);

        minTree[idx] = Math.min(minTree[2 * idx + 1], minTree[2 * idx + 2]);
        maxTree[idx] = Math.max(maxTree[2 * idx + 1], maxTree[2 * idx + 2]);
    }

    public int[] query(int ql, int qr) {
        return query(0, 0, n - 1, ql, qr);
    }

    private int[] query(int idx, int l, int r, int ql, int qr) {

        if (ql > r || qr < l) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        if (ql <= l && r <= qr) {
            return new int[]{minTree[idx], maxTree[idx]};
        }

        int mid = l + (r - l) / 2;

        int[] left = query(2 * idx + 1, l, mid, ql, qr);
        int[] right = query(2 * idx + 2, mid + 1, r, ql, qr);

        return new int[]{
            Math.min(left[0], right[0]),
            Math.max(left[1], right[1])
        };
    }
}
class Node {
    int i, j;
    long val;

    Node(int i, int j, long val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(nums);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));
        for (int i = 0; i < n; i++) {
            int[] res = st.query(i, n - 1);
            pq.offer(new Node(i, n - 1, (long) res[1] - res[0]));
        }
        long ans = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            Node cur = pq.poll();
            ans += cur.val;
            int i = cur.i;
            int j = cur.j - 1;
            if (i <= j) {
                int[] res = st.query(i, j);
                pq.offer(new Node(i, j, (long) res[1] - res[0]));
            }
        }

        return ans;
    }
}
