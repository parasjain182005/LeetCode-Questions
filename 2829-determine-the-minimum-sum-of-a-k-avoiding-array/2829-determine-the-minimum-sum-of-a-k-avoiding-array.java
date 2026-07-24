class Solution {
    public int minimumSum(int n, int k) {
        int ans = 0;
        int x=1, y=0;
        Set<Integer> set = new HashSet<>();
        while(y<n){
            if(x<=k && set.contains(k-x)){
                x++;
                continue;
            }
            set.add(x);
            ans+=x;
            x++;
            y++;
        }
        return ans;
    }
}