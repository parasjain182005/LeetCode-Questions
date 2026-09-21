class Solution {
    public boolean increasingTriplet(int[] nums) {
        int fmax = Integer.MAX_VALUE;
        int smax = Integer.MAX_VALUE;

        for(int x:nums){
            if(x<=fmax){
                fmax = x;
            }
            else if(x<=smax){
                smax = x;
            }
            else return true;
        }
        return false;
    }
}