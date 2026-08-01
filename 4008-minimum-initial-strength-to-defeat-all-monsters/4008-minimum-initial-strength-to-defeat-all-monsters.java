class Solution {
    public boolean check(int[] monsters, long[] bonus, long sum){
        for(int i=0; i<monsters.length; i++){
            if(sum+bonus[i]>=monsters[i]){
                sum-=monsters[i];
                if(sum<0) sum=0;
            }
            else return false;
        }
        return true;
    }
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        long l=0,r=0;
        for(int x:monsters) r+=x;
        int n = monsters.length;
        
        long[] diff = new long[n + 1];
        for (int[] b : boosts) {
            diff[b[0]] += b[2];
            if (b[1] + 1 < n)
                diff[b[1] + 1] -= b[2];
        }

        long[] bonus = new long[n];
        bonus[0] = diff[0];
        for (int i = 1; i < n; i++){
            bonus[i] = bonus[i - 1] + diff[i];
        }            
        
        while(l<=r){
            long mid = (l+r)/2;
            if(check(monsters, bonus, mid)) r=mid-1;
            else l=mid+1;
        }
        return l;
    }
}