class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int x = 0;

        for(char c:s.toCharArray()){
            if(c=='(' && x++ >0) sb.append('(');
            if(c==')' && x-- >1) sb.append(')');
        }

        return sb.toString();
    }
}