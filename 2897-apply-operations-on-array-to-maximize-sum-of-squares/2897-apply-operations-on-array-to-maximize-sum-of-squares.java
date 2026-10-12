class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] arr = new int[31];

        for(int x : nums){
            int i=0;
            while(x>0){
                int a = x & 1;
                if(a==1) arr[i]++;
                i++;
                x = x>>1;
            }
        }

        long ans = 0;
        int mod = 1000000007;

        for(int j=0; j<k; j++){
            long x = 0;
            for(int i=0; i<31; i++){
                if(arr[i]>0){
                    x+=(1<<i);
                    arr[i]--;
                }
            }

            ans = (ans + (x * x) % mod) % mod;
        }
        return (int) ans;
    }
}