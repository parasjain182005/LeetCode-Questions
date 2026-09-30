class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int max = 0;
        int[] ans = new int[seq.length()];
        int i=0;
        for(char c:seq.toCharArray()){
            if(c=='('){
                max++;
                ans[i] = max%2;
            }
            else{
                ans[i] = max%2;
                max--;
            }
            i++;
        }
        return ans;
    }
}