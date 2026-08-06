class Solution {
    public int product(int n){
        int x = 1;
        while(n>0){
            x*=(n%10);
            n/=10;
        }
        return x;
    }
    public int smallestNumber(int n, int t) {
        int ans = n;
        while(true){
            if(product(ans)%t==0) break;
            ans++;
        }
        return ans;
    }
}