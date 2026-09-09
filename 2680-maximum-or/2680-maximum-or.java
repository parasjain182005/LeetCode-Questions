class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long[] pref = new long[n];
        pref[0] = 0;
        long[] suf = new long[n];
        suf[n-1] = 0;

        for(int i=1; i<n; i++){
            pref[i] = pref[i-1] | nums[i-1];
        }
        for(int i=n-2; i>=0; i--){
            suf[i] = suf[i+1] | nums[i+1];
        }

        long ans = 0;
        for(int i=0; i<n; i++){
            long sum = (pref[i] | suf[i]) | (long)(nums[i]*Math.pow(2,k));
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}