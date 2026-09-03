class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            int j = i+1;
            if(j==n) j=0;
            while(j<n){
                if(j==i){
                    arr[i] = -1;
                    break;
                }

                if(nums[i]<nums[j]){
                    arr[i] = nums[j];
                    break;
                }
                
                j++;
                if(j==n) j=0;
            }
        }
        return arr;
    }
}