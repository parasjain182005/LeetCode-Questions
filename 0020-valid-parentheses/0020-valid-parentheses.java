class Solution {
    public boolean isValid(String x) {
        Stack<Character> s = new Stack<>();
        for(char k:x.toCharArray()){
            if(k=='('||k=='{'||k=='['){
                s.push(k);
            }
            else{
                if(s.isEmpty()) return false;
                char a = s.pop();
                if((a=='('&&k!=')')||
                (a=='{'&&k!='}')||
                (a=='['&&k!=']')) return false;
            }
        }
        if(!s.isEmpty()) return false;
        return true;
    }
}