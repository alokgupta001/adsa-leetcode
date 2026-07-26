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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,0,new ArrayList<>());
        return ans;
    }
    List<List<Integer>> ans = new ArrayList<>();
    void dfs(TreeNode root,int targetSum,int sum,List<Integer> l1){
        if(root==null) return;
        sum+=root.val;
        l1.add(root.val);
        if(root.left==null && root.right==null){
            if(targetSum==sum){
                ans.add(new ArrayList<>(l1));
            }
            l1.remove(l1.size()-1);
            return;
            
        }
        dfs(root.left,targetSum,sum,l1);
        dfs(root.right,targetSum,sum,l1);
        l1.remove(l1.size()-1);
    }
}