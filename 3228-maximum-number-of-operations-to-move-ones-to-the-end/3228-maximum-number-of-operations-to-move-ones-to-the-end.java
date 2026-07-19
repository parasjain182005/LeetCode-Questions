class Solution {
    public int maxOperations(String s) {
        int ans = 0;
        int x=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1') x++;
            else{
                if(i+1<s.length() && s.charAt(i+1)=='0') continue;
                ans+=x;
            }
        }
        return ans;
    }
}