class Solution {
    public boolean valid(String s){
        int a = 0;
        for(char k:s.toCharArray()){
            if(k=='(') a++;
            else a--;
            if (a < 0) return false; 
        }
        if(a==0) return true;
        return false;
    }
    public void parentheses(List<String> list, String s, int n){
        if(s.length()==2*n){
            if(valid(s)) list.add(s);
            return;
        }
        parentheses(list,s+"(",n);
        parentheses(list,s+")",n);
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String s = "(";
        parentheses(list,s,n);
        return list;
    }
}