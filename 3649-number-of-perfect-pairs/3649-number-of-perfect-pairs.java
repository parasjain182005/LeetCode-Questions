class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int a=0;
        for(int x:nums){
            arr[a] = Math.abs(x);
            a++;
        }
        Arrays.sort(arr);
        long ans = 0;
        int j = 0;

        for(int i = 0; i < n; i++){
            while(j < n && arr[j] <= 2 * arr[i]){
                j++;
            }
            ans += (j - i - 1);
        }
        return ans;
    }
}