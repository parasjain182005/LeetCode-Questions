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
    public void add(TreeNode root, int val, int depth, int x){
        if(root==null) return;
        
        if(x==depth-1){
            TreeNode l = root.left;
            TreeNode r = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = l;
            root.right.right = r;
            return;
        }
        add(root.left, val, depth, x+1);
        add(root.right, val, depth, x+1);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        add(root, val, depth, 1);
        return root;
    }
}