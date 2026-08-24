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
    public TreeNode tree(int[] nums, int s, int e){
        if(s>e || e<s) return null;

        int max = nums[s], idx = s;
        for(int i=s; i<=e; i++){
            if(max<nums[i]){
                max = nums[i];
                idx = i;
            }
        }

        TreeNode temp = new TreeNode(max);
        temp.left = tree(nums, s, idx-1);
        temp.right = tree(nums, idx+1, e);

        return temp;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return tree(nums, 0, nums.length-1);
    }
}