class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]<0) nums[i]*=-1;
        }
        Arrays.sort(nums);
        long s1 = 0, s2 = 0;
        int x = nums.length/2;
        for(int i=0; i<nums.length; i++){
            if(i<x) s2 += (long)(nums[i]*nums[i]);
            else s1 += (long)(nums[i]*nums[i]);
        }
        return s1-s2;
    }
}