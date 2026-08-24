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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> l = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int s = q.size();
            long sum = 0;
            for(int i=0; i<s; i++){
                TreeNode x = q.poll();
                sum+=x.val;
                if(x.left!=null) q.add(x.left);
                if(x.right!=null) q.add(x.right);
            }
            l.add(sum);
        }

        Collections.sort(l);
        if(l.size()<k) return -1;
        return l.get(l.size()-k);
    }
}