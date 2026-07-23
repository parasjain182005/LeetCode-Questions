class Solution {
    public int addRungs(int[] rungs, int dist) {
        int ans = 0;
        int x = 0;
        for(int i:rungs){
            if(i-x<=dist) x=i;
            else{
                int y = (i-x)/dist;
                ans+=y;
                if((i-x)%dist==0) ans--;
                x=i;
            }
        }
        return ans;
    }
}