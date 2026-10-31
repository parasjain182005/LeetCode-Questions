class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int x:arr){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        Map<Integer, List<Integer>> m = new HashMap<>();

        for(int x:map.keySet()){
            m.computeIfAbsent(map.get(x), k -> new ArrayList<>()).add(x);
            if(m.get(map.get(x)).size()>1) return false;
        }

        return true;
    }
}