class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> list = new ArrayList<>();
        for(int[] x:grid){
            for(int i:x){
                list.add(i);
            }
        }
        int n = k%list.size();

        for(int i=0; i<n; i++){
            int x = list.get(list.size()-1);
            list.remove(list.size()-1);
            list.add(0,x);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<list.size();){
            List<Integer> l = new ArrayList<>();
            for(int j=0; j<grid[0].length; j++){
                l.add(list.get(i));
                i++;
            }
            ans.add(l);
        }
        return ans;
    }
}