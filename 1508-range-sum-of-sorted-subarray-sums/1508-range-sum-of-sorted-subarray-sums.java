class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1_000_000_007;
        int x = n*(n+1)/2;
        int[] arr = new int[x];

        int y=0;
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum+=nums[j];
                arr[y] = sum;
                y++;
            }
        }

        Arrays.sort(arr);
        long ans = 0;
        for(int i=left-1; i<right; i++){
            ans+=arr[i];
            ans%=mod;
        }
        return (int)ans;
    }
}