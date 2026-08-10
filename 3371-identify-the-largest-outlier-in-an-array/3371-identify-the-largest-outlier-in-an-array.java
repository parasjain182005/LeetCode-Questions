class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for(int x:nums){
            map.put(x, map.getOrDefault(x,0)+1);
            sum+=x;
        }
        int ans = Integer.MIN_VALUE;
        for(int x:nums){
            int y=sum-x;

            if(y%2==0 && map.containsKey(y/2)){
                if (x == y/2 && map.get(x) < 2) {
                    continue;
                }
                ans = Math.max(ans,x);
            }
        }
        return ans;
    }
}