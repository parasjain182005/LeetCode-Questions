class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();
        int i=0;
        for(int[] x:variables){
            int x1 = modPow(x[0], x[1], 10);  
            int temp = modPow(x1, x[2], x[3]);  
            if(temp==target) list.add(i);
            i++;         
        }
        return list;
    }
    public int modPow(int base, int exp, int mod) {
        int result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}