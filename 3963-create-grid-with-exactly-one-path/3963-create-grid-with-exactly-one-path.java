class Solution {
    public String[] createGrid(int m, int n) {
        String r1="";
        String r2="";
        for(int i=0; i<n; i++){
            if(i<n-1){
                r2+="#";
            }
            else r2+=".";

            r1+=".";
        }
        String[] ans = new String[m];
        ans[0]=r1;
        for(int i=1; i<m; i++) ans[i] = r2;
        return ans;
    }
}