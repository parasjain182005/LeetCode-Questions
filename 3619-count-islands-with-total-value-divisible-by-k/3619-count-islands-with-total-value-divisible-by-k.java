class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][]vis = new int[n][m];
        int cnt = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(vis[i][j]==0 && grid[i][j]>0){

                    long sum = dfs(i,j,vis,grid);
                    if(sum%k==0)cnt++;
                }
            }

        }
        return cnt;
    }

    public long dfs(int row,int col,int[][]vis, int [][]grid ){
        vis[row][col] = 1;
        int n = grid.length, m= grid[0].length;
        long total = grid[row][col];
        int[]delrow = {-1,0,+1,0};
        int [] delcol = {0,+1,0,-1};

        for(int i = 0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col+delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&vis[nrow][ncol]==0 && grid[nrow][ncol]>0 ){
                total +=  dfs(nrow,ncol,vis,grid);
            }
        }
        return total;
    }
}