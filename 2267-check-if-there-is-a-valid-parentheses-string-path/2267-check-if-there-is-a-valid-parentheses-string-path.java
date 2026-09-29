class Solution {
    private boolean[][][] vis;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        if((m+n)%2==0 || grid[m-1][n-1]!=')' || grid[0][0]!='(') return false;

        int max = (m+n)/2;
        vis = new boolean[m][n][max+1];
        return dfs(grid, 0, 0, 0, m, n, max);
    }

    public boolean dfs(char[][] grid, int r, int c, int bal, int m, int n, int max){
        if(grid[r][c] == '(') bal++;
        else bal--;

        if(bal<0 || bal>max) return false;

        if (r == m - 1 && c == n - 1) {
            if(bal == 0) return true;
            return false;
        }

        if (vis[r][c][bal]) {
            return false;
        }

        vis[r][c][bal] = true;

        if (r + 1 < m && dfs(grid, r + 1, c, bal, m, n, max)) {
            return true;
        }

        if (c + 1 < n && dfs(grid, r, c + 1, bal, m, n, max)) {
            return true;
        }

        return false;
    }
}