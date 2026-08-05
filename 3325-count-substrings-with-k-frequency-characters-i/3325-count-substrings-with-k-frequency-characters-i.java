class Solution {
    public int numberOfSubstrings(String s, int k) {
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            int[] arr = new int[26];
            int x = 0;
            for(int j=i; j<s.length(); j++){
                arr[s.charAt(j)-'a']++;
                if(arr[s.charAt(j)-'a']>=k) x++;

                if(x>0) ans++;
            }
        }
        return ans;
    }
}