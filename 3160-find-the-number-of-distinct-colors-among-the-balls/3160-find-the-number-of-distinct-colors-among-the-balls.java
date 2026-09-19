class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            if(map.containsKey(queries[i][0])){
                int x = map.get(queries[i][0]);
                map1.put(x, map1.get(x)-1);

                if(map1.get(x)==0) map1.remove(x);
            }

            map.put(queries[i][0], queries[i][1]);
            map1.put(queries[i][1], map1.getOrDefault(queries[i][1],0)+1);
            ans[i] = map1.size();
        }
        return ans;
    }
}