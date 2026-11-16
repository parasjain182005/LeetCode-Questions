class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder sb = new StringBuilder();
            int count=0, sum=0;
            for(char c:s.toCharArray()){
                int x = c-'0';
                count++;
                sum+=x;
                if(count==k){
                    sb.append(Integer.toString(sum));
                    count=0;
                    sum=0;
                }
            }
            if(count>0 && count<k) sb.append(Integer.toString(sum));

            s = sb.toString();
        }
        return s;
    }
}