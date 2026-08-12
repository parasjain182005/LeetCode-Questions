class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0;
        Set<Character> unique = new HashSet<>();
        for(int r=0; r<s.length(); r++){
            char x = s.charAt(r);

            while(unique.contains(x)){
                unique.remove(s.charAt(l));
                l++;
            }

            unique.add(x);
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}