class Solution {
    public int minMoves(int[] nums) {
        if(nums.length == 0) return 0;

        int min = nums[0];
        for(int n : nums){
            min = Math.min(min, n);
        } 
        int ans = 0;
        for(int n : nums){
            ans += n - min;
        } 
        return ans;
    }
}