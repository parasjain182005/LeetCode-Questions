class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();

        boolean[][] q = new boolean[8][8];
        for (int[] x: queens) {
            q[x[0]][x[1]] = true;
        }

        int[][] dir={{-1,0}, {1,0}, {0,1}, {0,-1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

        for(int d[]: dir){
            int dr=king[0];
            int dc=king[1];

            while(dr>=0 && dr<8 && dc>=0 && dc<8){
                dr+=d[0];
                dc+=d[1];

                if (dr < 0 || dr >= 8 || dc < 0 || dc >= 8) break;

                
                if(q[dr][dc]){
                    ans.add(Arrays.asList(dr,dc));
                    break;
                }
            }
        }
        return ans;
    }
}