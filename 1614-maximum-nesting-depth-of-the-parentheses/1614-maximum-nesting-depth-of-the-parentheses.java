class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int x = 0,y=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                st.push('(');
                y++;
            }
            if(s.charAt(i)==')'){
                x = Math.max(x,y);
                st.pop();
                y--;
            }
        }
        return x;
    }
}