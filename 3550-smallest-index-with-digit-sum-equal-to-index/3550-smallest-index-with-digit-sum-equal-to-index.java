class Solution {
    public int digitSum(int sum){
        int s = 0;
        while(sum!=0){
            s+=sum%10;
            sum/=10;
        }
        return s;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(digitSum(nums[i])==i) return i;
        }
        return -1;
    }
}