class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(9*num < sum) return "";
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<num; i++){
            if(sum>=9){
                ans.append("9");
                sum-=9;
            }
            else if(sum>0){
                ans.append(Integer.toString(sum));
                sum=0;
            }
            else{
                ans.append("0");
            }
        }
        return ans.toString();
    }
}