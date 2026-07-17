class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int x = 0;
        for(char c : s.toCharArray()){
            if (c == '(' && x++ > 0) ans += c;
            if (c == ')' && x-- > 1) ans += c;
        }
        return ans;
    }
}