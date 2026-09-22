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
    public void dfs(TreeNode root, int max, int[] ans){
        if(root==null) return;

        int x = Math.max(max, root.val);
        if(root.val==x){
            ans[0]++;
        }
        dfs(root.left, x, ans);
        dfs(root.right, x, ans);
    }
    public int goodNodes(TreeNode root) {
        int[] ans = new int[1];
        dfs(root, Integer.MIN_VALUE, ans);
        return ans[0];
    }
}