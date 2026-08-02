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
    public int dfs(TreeNode root, Map<Integer, Integer> map){
        if(root==null) return 0;

        int l = dfs(root.left,map);
        int r = dfs(root.right,map);

        int x = l+r+root.val;
        map.put(x,map.getOrDefault(x,0)+1);

        return x;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        dfs(root,map);

        int max = 0;
        for(int x:map.keySet()){
            max = Math.max(max,map.get(x));
        }

        List<Integer> list = new ArrayList<>();
        for(int sum : map.keySet()){
            if(map.get(sum) == max){
                list.add(sum);
            }
        }

        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}