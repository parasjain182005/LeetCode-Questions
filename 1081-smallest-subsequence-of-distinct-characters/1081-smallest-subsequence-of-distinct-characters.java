class Solution {
    public String smallestSubsequence(String s) {
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'a'] = i;
        }

        boolean[] vis = new boolean[26];
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(vis[c-'a']==true) continue;

            while(!st.isEmpty() && c<st.peek() && i<arr[st.peek()-'a']){
                vis[st.pop()-'a'] = false;
            }
            st.push(c);
            vis[c-'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return   sb.reverse().toString(); 
    }
}