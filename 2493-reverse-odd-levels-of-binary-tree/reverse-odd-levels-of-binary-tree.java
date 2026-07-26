/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> nodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                nodes.add(curr);

                if (curr.left != null) {
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }

            if (level % 2 == 1) {
                int i = 0, j = nodes.size() - 1;
                while (i < j) {
                    int temp = nodes.get(i).val;
                    nodes.get(i).val = nodes.get(j).val;
                    nodes.get(j).val = temp;
                    i++;
                    j--;
                }
            }

            level++;
        }

        return root;
    }
}