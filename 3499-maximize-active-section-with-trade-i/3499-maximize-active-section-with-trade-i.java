class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t = "1"+s+"1";
        int ones = 0;
        for(char c : s.toCharArray()) {
            if(c=='1') ones++;
        }
        int ans = ones;
        int i = 1;
        while (i < t.length() - 1) {
            
            if (t.charAt(i) == '0') {
                int lz = 0;
                while (i < t.length() && t.charAt(i) == '0') {
                    lz++;
                    i++;
                }

                int one = 0;
                while (i < t.length() && t.charAt(i) == '1') {
                    one++;
                    i++;
                }

                int rz = 0;
                int j = i;
                while (j < t.length() && t.charAt(j) == '0') {
                    rz++;
                    j++;
                }

                if (one > 0 && rz > 0) {
                    ans = Math.max(ans, ones+lz+rz);
                }
            }
            else i++;
        }
        return ans;
    }
}