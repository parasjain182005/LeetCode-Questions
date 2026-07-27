class pair{
    int r;
    int c;
    pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int check(int[][] grid, int[][] vis, int row, int col, int[] delrow, int[] delcol){
        int ans = 0;
        vis[row][col] = 1;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(row, col));

        while(!q.isEmpty()){
            ans++;
            pair p = q.poll();
            int r = p.r;
            int c = p.c;


            for(int i=0; i<4; i++){
                int r1 = r+delrow[i];
                int c1 = c+delcol[i];

                if(r1>=0 && r1<grid.length && c1>=0 && c1<grid[0].length 
                && grid[r1][c1] == 1 && vis[r1][c1]==0){
                    q.add(new pair(r1, c1));
                    vis[r1][c1]=1;
                }
            }
        }
        return ans;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        int[] delrow = {0,0,1,-1};
        int[] delcol = {1,-1,0,0};

        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    ans = Math.max(ans, check(grid, vis, i, j, delrow, delcol)) ;
                }
            }
        }
        return ans;
    }
}