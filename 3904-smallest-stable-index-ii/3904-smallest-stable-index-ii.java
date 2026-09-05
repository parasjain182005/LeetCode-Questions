class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] arr = new int[nums.length];
        arr[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            arr[i] = Math.min(arr[i+1], nums[i]);
        }
        int max = nums[0];
        for(int i=0; i<nums.length; i++){
            max = Math.max(max,nums[i]);
            if(Math.abs(max-arr[i])<=k) return i;
        }
        return -1;
    }
}