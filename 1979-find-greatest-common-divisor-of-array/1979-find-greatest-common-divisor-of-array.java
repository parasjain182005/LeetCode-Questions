class Solution {
    public int findGCD(int[] nums) {
        int min=Integer.MAX_VALUE, max=0;
        for(int x:nums){
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        while(max>0){
            int temp = min%max;
            min = max;
            max = temp;
        }
        return min;
    }
}