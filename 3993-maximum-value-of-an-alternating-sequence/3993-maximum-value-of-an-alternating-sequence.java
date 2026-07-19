class Solution {
    public long maximumValue(int n, int s, int m) {
        if (n == 1) return s;
        long ans = s;
        if((n-1)%2==0){
            long x = (long) m*((n-1)/2);
            long y = (n-1)/2-1;
            ans=s+x-y;
        }
        else{
            long x = (long) m*((n-1)/2+1);
            long y = (n-1)/2;
            ans=s+x-y;
        }
        return ans;
    }
}