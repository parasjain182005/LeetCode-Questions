class Solution {
    public String reverseParentheses(String st) {
        Stack<Character> s = new Stack<>();

        for(char c:st.toCharArray()){

            if(c==')'){
                StringBuilder sb = new StringBuilder();

                while(s.peek()!='('){
                    sb.append(s.pop());
                }
                s.pop();

                for(char ch:sb.toString().toCharArray()){
                    s.push(ch);
                }
            }

            else s.push(c);
        }

        StringBuilder sb = new StringBuilder();

        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.reverse().toString();
    }
}