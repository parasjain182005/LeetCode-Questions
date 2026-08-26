class Solution {
    public String small(String s1, String s2){
        if(s1.equals(s2)) return s1;

        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(s1.charAt(i)=='1') return s2;
                else return s1;
            }
        }
        return s1;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        StringBuilder sb = new StringBuilder();
        
        int c = 0, j=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                c++;
            }
            sb.append(s.charAt(i));

            while(c>k || (j <= i && s.charAt(j) == '0')){
                if(s.charAt(j)=='1') c--;
                sb.deleteCharAt(0);
                j++;
            }

            if(c==k){
                if(ans.equals("") || ans.length()>sb.length()) ans = sb.toString();
                else if(ans.length() == sb.length()){
                    ans = small(ans, sb.toString());
                } 
            }
        }
        return ans;
    }
}