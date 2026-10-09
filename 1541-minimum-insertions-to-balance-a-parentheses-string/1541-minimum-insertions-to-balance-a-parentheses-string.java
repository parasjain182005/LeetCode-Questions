class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int ans=0, x=0;

        for(char c : s.toCharArray()){
            if(c=='('){
                if(x==1){
                    ans++;
                    x--;
                    if(!st.isEmpty()) st.pop();
                    else ans++;
                }
                st.push('(');
            } 
            else{
                x++;
                if(st.isEmpty()){
                    ans++;
                    st.push('(');
                }
                else if(x>=2){
                    st.pop();
                    x-=2;
                }
            }
        }
        if(x==1){
            ans++;
            st.pop();
        }
        if(!st.isEmpty()){
            ans+=st.size()*2;
        }
        return ans;
    }
}