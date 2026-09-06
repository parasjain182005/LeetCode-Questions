class Solution {
    public int combinations(int i, int j, String s, String t, int[][] dp){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int count = 0;
        if(s.charAt(i)==t.charAt(j)){
            count+=combinations(i+1, j+1, s, t, dp);
        }
        
        count+=combinations(i+1, j, s, t, dp);
        return dp[i][j]=count;
    }
    public int numDistinct(String s, String t) {
        int[][]  dp = new int[s.length()][t.length()];
        for(int i=0; i<s.length(); i++){
            Arrays.fill(dp[i],-1);
        }        
        int ans = combinations(0, 0, s, t, dp);
        return ans;
    }
}