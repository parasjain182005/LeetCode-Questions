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
    public void dfs(TreeNode root, Map<Integer, Integer> map){
        if(root==null) return;
        map.put(root.val, map.getOrDefault(root.val,0)+1);

        dfs(root.left, map);
        dfs(root.right, map);
    }
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);

        int max = 0;
        for(int x:map.values()){
            max = Math.max(max,x);
        }

        List<Integer> l = new ArrayList<>();
        for(int x:map.keySet()){
            if(map.get(x)==max){
                l.add(x);
            }
        }

        int[] ans = new int[l.size()];
        for(int i=0; i<l.size(); i++){
            ans[i] = l.get(i);
        }

        return ans;
    }
}