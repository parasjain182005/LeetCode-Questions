class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        int n = arr.length;
        long sum1 = 0;
        for(int i=0; i<n; i++){
            sum1+=Math.abs(arr[i]-brr[i]);
        }

        Arrays.sort(arr);
        Arrays.sort(brr);
        long sum2 = k;
        for(int i=0; i<n; i++){
            sum2+=Math.abs(arr[i]-brr[i]);
        }

        return Math.min(sum1, sum2);
    }
}