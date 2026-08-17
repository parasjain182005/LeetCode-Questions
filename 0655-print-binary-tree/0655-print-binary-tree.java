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
    public int height(TreeNode root){
        if(root==null) return 0;        
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public void matrixTree(TreeNode root,List<List<String>> ans,int r,int cs,int ce){
        if(root==null) return;

        int x = (ce+cs)/2;
        ans.get(r).set(x, Integer.toString(root.val));
        matrixTree(root.left, ans, r+1, cs, x-1);
        matrixTree(root.right, ans, r+1, x+1, ce);
    }
    public List<List<String>> printTree(TreeNode root) {
        int h = height(root);
        int c = (int)Math.pow(2,h)-1;

        List<List<String>> ans = new ArrayList<>();
        List<String> l = new ArrayList<>();
        for(int i=0; i<c; i++) l.add("");
        for(int i=0; i<h; i++) ans.add(new ArrayList<>(l));

        matrixTree(root, ans, 0, 0, c-1);
        return ans;        
    }
}