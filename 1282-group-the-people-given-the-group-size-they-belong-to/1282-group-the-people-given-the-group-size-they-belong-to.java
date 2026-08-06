class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();        
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<groupSizes.length; i++){
            map.putIfAbsent(groupSizes[i], new ArrayList<>());
            map.get(groupSizes[i]).add(i);

            if(map.get(groupSizes[i]).size()==groupSizes[i]){
                ans.add(map.get(groupSizes[i]));
                map.remove(groupSizes[i]);
            }
        }
        return ans;
    }
}