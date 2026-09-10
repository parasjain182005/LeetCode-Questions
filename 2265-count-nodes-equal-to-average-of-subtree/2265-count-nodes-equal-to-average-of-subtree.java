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
    public int[] average(TreeNode root, int[] ans){
        if(root==null) return new int[]{0,0};

        int[] l = average(root.left, ans);
        int[] r = average(root.right, ans);

        int x = root.val+l[0]+r[0];
        int y = 1+l[1]+r[1];

        if(x/y == root.val) ans[0]++;

        return new int[]{x,y};
    }
    public int averageOfSubtree(TreeNode root) {
        int[] ans = new int[1];
        average(root, ans);
        return ans[0];
    }
}