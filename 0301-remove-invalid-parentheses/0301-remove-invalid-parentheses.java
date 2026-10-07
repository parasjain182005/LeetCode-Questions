class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        int open = 0;
        int close = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } 
            else if (ch == ')') {
                if (open > 0) {
                    open--;
                } 
                else {
                    close++;
                }
            }
        }
        solve(s, 0, open, close, 0, "", ans);
        return ans;
    }
    void solve(String s, int index, int openR, int closeR,
        int balance, String current, List<String> ans) {

        if (index == s.length()) {
            if (openR == 0 && closeR == 0 && balance == 0) {
                if (!ans.contains(current)) {
                    ans.add(current);
                }
            }
            return;
        }

        char ch = s.charAt(index);

        if (ch == '(' && openR > 0) {
            solve(s, index+1, openR - 1, closeR, balance, current, ans);
        }
        if (ch == ')' && closeR > 0) {
            solve(s, index+1, openR, closeR - 1, balance, current, ans);
        }
        if (ch != '(' && ch != ')') {
            solve(s, index+1, openR, closeR, balance, current + ch, ans);
        } 
        else if (ch == '(') {
            solve(s, index+1, openR, closeR, balance + 1, current + ch, ans);
        } 
        else if (balance > 0) {
            solve(s, index+1, openR, closeR, balance - 1, current + ch, ans);
        }
    }
}