class Solution {
    public long countCommas(long n) {
        long ans =0;

        long s=1000;
        int commas=1;
        while(s<=n){
            long end = s*1000-1;
            long upper = Math.min(n,end);
            if(upper>=s){
                ans+=(upper-s+1)*commas;
                s*=1000;
                commas++;
            }
        }
        return ans;
    }
}