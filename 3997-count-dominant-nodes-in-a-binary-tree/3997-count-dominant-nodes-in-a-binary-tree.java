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
    public int dfs(TreeNode root, int[] ans){
        if(root.left==null && root.right==null){
            ans[0]++;
            return root.val;
        }
        int x=0;

        if(root.left!=null) x=Math.max(x,dfs(root.left, ans));
        if(root.right!=null) x=Math.max(x,dfs(root.right, ans));
        if(x<=root.val) ans[0]++;
        return Math.max(x,root.val);        
    }
    public int countDominantNodes(TreeNode root) {
        int[] ans = new int[1];
        dfs(root, ans);
        return ans[0];
    }
}