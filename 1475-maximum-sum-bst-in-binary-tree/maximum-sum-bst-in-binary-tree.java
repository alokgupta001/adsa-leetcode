class Solution {
    int maxSum = 0;
    class Pair {
        boolean isBST;
        int sum;
        int min;
        int max;
        Pair(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }
    public int maxSumBST(TreeNode root) {
        solve(root);
        return maxSum;
    }
    Pair solve(TreeNode root) {
        if (root == null) {
            return new Pair(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        if (!left.isBST || !right.isBST) {
            return new Pair(false, 0, 0, 0);
        }
        if (root.val <= left.max || root.val >= right.min) {
            return new Pair(false, 0, 0, 0);
        }
        int currentSum = root.val + left.sum + right.sum;
        maxSum = Math.max(maxSum, currentSum);
        int currentMin = Math.min(root.val, left.min);
        int currentMax = Math.max(root.val, right.max);
        return new Pair(true, currentSum, currentMin, currentMax);
    }
}