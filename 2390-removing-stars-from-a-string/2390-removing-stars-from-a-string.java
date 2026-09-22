class Solution {
    public String removeStars(String st) {
        Stack<Character> s = new Stack<>();

        for(char ch:st.toCharArray()){
            if(ch!='*'){
                s.push(ch);
            }
            else{
                s.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}