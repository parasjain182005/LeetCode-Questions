class Solution {
    public long maximumProduct(int[] nums, int m) {
        int n = nums.length;
        int[] ps = new int[n];
        int[] ns = new int[n];
        ps[n-1]=nums[n-1];
        ns[n-1]=nums[n-1];

        for(int i=n-2; i>=0; i--){
            ps[i] = Math.max(nums[i],ps[i+1]);
            ns[i] = Math.min(nums[i],ns[i+1]);
        }

        long max = Long.MIN_VALUE;
        for(int i=0; i<=nums.length-m; i++){
            long x = (long)nums[i];
            if(x<0) x*=ns[i+m-1];
            else x*=ps[i+m-1];
            max = Math.max(max,x);
        }
        return max;
    }
}