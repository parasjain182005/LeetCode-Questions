class pair{
    char val;
    int count;
    pair(char val, int count){
        this.val = val;
        this.count = count;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<pair> st = new Stack<>();

        for(char ch:s.toCharArray()){
            if(st.isEmpty()){
                st.push(new pair(ch,1));
                continue;
            }

            pair p = st.peek();
            if(p.val==ch){
                p.count+=1;
                if(p.count==k) st.pop();
            }
            else st.push(new pair(ch,1));
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            pair p = st.pop();
            int i=0;
            while(i<p.count){
                sb.append(p.val);
                i++;
            } 
        }
        sb.reverse();
        return sb.toString();
    }
}