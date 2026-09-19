class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(1);
        int a = 2;
        while(true){
            int x = l.get(a-1)+l.get(a-2);
            if(x>k) break;
            l.add(x);
            a++;
        }

        int ans = 0;

        for(int i=a-1; i>=0; i--){
            if(l.get(i)<=k){
                ans++;
                k-=l.get(i);
            }
        }
        return ans;
    }
}