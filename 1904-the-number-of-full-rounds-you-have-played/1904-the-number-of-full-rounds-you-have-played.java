class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int h1 = Integer.parseInt(loginTime.substring(0,2));
        int m1 = Integer.parseInt(loginTime.substring(3));
        int h2 = Integer.parseInt(logoutTime.substring(0,2));
        int m2 = Integer.parseInt(logoutTime.substring(3));

        if(h1>h2 || (h1==h2 && m1>m2)){
            h2+=24;
        }

        int ans = 0, sh=0,sm=0;
        while(sh < h2 || (sh == h2 && sm <= m2)){
            if(sh > h1 || (sh == h1 && sm >= m1)){
                int x =sm+15;
                int y = sh;
                if(x>=60){
                    x=0;
                    y=sh+1;
                }
                if(y < h2 || (y == h2 && x <= m2)) ans++;
            }
            sm+=15;
            if(sm>=60){
                sm=0;
                sh++;
            }
        }
        return ans;
    }
}