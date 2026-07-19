class Solution {
    public String rearrangeString(String s, char x, char y) {
        String s1="", s2="", s3="";
        for(char c:s.toCharArray()){
            if(c==x) s3+=c;
            else if(c==y) s1+=c;
            else s2+=c;
        }
        return s1+s2+s3;
    }
}