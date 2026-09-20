class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        int i=1;
        for(char c:s.toCharArray()){
            int x = 26-(c-'a');
            ans+=x*i;
            i++;
        }
        return ans;
    }
}