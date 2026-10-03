class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int open = 0, close = 0;

        for(char c:s.toCharArray()){
            if(c=='(') open++;
            else close++;

            if(open==close){
                ans = Math.max(ans, 2*open);
            }
            else if(close>open){
                open = 0;
                close = 0;
            }
        }

        open = 0;
        close = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)=='(') open++;
            else close++;

            if(open==close){
                ans = Math.max(ans, 2*open);
            }
            else if(close<open){
                open = 0;
                close = 0;
            }
        }

        return ans;
    }
}