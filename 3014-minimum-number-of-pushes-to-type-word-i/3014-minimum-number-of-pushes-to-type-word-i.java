class Solution {
    public int minimumPushes(String word) {
        int x = word.length(); 
        int sum = 0;
        if(x>24){
            int a = x-24;
            sum+= a*4;
            x-=a;
        }
        if(x>16){
            int a = x-16;
            sum+= a*3;
            x-=a;
        }
        if(x>8){
            int a = x-8;
            sum+= a*2;
            x-=a;
        }
        if(x>0){
            int a = x-0;
            sum+= a*1;
            x-=a;
        }
        return sum;
    }
}