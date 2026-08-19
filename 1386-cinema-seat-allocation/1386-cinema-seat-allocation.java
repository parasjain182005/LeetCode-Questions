class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int ans = 0;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] x : reservedSeats) {
            map.computeIfAbsent(x[0], k -> new HashSet<>()).add(x[1]);
        }
        ans = (n - map.size()) * 2;

        for(int i:map.keySet()){
            boolean can1 = true, can2 = true;
            Set<Integer> s = map.get(i);


            if(!s.contains(2) && !s.contains(3) && !s.contains(4) && !s.contains(5)){
                ans++;
                can1 = false;
            }
            if(!s.contains(6) && !s.contains(7) && !s.contains(4) && !s.contains(5) && can1){
                ans++;
                can2 = false;
            }
            if(!s.contains(6) && !s.contains(7) && !s.contains(8) && !s.contains(9) && can2){
                ans++;
            }
        }
        return ans;
    }
}