class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int x = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {

                map.computeIfAbsent(i + j, k -> new ArrayList<>())
                .add(nums.get(i).get(j));
                x++;
            }
        }

        int[] ans = new int[x];
        int idx = 0;

        for (int d = 0; map.containsKey(d); d++) {
            List<Integer> list = map.get(d);
            for (int i = list.size() - 1; i >= 0; i--) {
                ans[idx++] = list.get(i);
            }
        }

        return ans;
    }
}