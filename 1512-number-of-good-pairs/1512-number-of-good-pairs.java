class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int x:nums){
            if(map.containsKey(x)){
                ans+=map.get(x);
            }
            map.put(x, map.getOrDefault(x,0)+1);
        }
        return ans;
    }
}