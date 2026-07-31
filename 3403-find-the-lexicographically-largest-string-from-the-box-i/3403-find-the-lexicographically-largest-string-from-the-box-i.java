class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1) return word;

        int m = word.length();
        int n = word.length()-numFriends+1;

        String ans = "";

        for(int i=0; i<word.length(); i++){
            String x = word.substring(i, Math.min(m,i+n));

            if(x.compareTo(ans)>0) ans = x;
        }
        return ans;
    }
}