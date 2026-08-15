class Solution {
    public int longestSubsequence(int[] nums) {
        int sum = 0;
        if(nums.length==1 && nums[0] == 0) return 0;
        int y = nums.length;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            int x = nums[i];
            for(int j=i+1; j<nums.length; j++){
                x = x^nums[j];
            }
            if(x!=0) return y;
            else y--;
        }
        if(sum==0) return 0;
        return y;
    }
}