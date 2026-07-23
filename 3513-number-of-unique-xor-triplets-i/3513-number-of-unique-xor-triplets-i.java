class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(nums.length<=2) return n;

        Arrays.sort(nums);
        String x = Integer.toBinaryString(nums[n-1]);
        int a = x.length();
        return (int)Math.pow(2,a);
    }
}