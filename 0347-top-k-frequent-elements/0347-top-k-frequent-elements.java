class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x:nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        for(int x:map.keySet()){
            pq.add(new int[]{x,map.get(x)});
        }

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            int[] x = pq.poll();
            ans[i] = x[0];
        }

        return ans;
    }
}