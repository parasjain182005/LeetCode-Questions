class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int i=0;
        while(i<nums.length){
            int j=i+1;
            while(j<nums.length){
                if(nums[i]+nums[j]==target){
                    arr[0]=i;
                    arr[1]=j;
                }
                j++;
            }
            i++;
        }
        return arr;       
    }
}