class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(vis[i],-1);

        int[] delrow = {0,0,1,-1};
        int[] delcol = {1,-1,0,0};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,k,0});
        vis[0][0] = k;

        while(!q.isEmpty()){
            int[] p = q.poll();
            
            int row = p[0];
            int col = p[1];

            if(row==n-1 && col==m-1) return p[3];

            for(int i=0; i<4; i++){
                int r = row+delrow[i];
                int c = col+delcol[i];

                if(r>=0 && r<n && c>=0 && c<m){
                    if(grid[r][c]==0 &&  p[2] > vis[r][c]){
                        q.offer(new int[]{r,c,p[2],p[3]+1});
                        vis[r][c]=p[2];
                    }
                    else if(grid[r][c] == 1 && p[2] > 0 && p[2] - 1 > vis[r][c]) {
                        q.offer(new int[]{r, c, p[2] - 1, p[3] + 1});
                        vis[r][c] = p[2] - 1;
                    }
                }
            }

        }
        return -1;
    }
}