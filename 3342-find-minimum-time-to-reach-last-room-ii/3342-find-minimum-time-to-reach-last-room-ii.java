class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][][] dist = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j][1] = Integer.MAX_VALUE;
                dist[i][j][2] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        pq.add(new int[]{0,0,0,1});
        dist[0][0][1] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!pq.isEmpty()){
            int[] x = pq.poll();

            int r = x[0];
            int c = x[1];
            int time = x[2];
            int cost = x[3];

            if (time != dist[r][c][cost]) {
                continue;
            }
            if(r==n-1 && c==m-1) return time;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                int wait = Math.max(0, moveTime[nr][nc] - time);
                int newTime = time + wait + cost;
                int nextCost = 3 - cost;

                if (newTime < dist[nr][nc][nextCost]) {
                    dist[nr][nc][nextCost] = newTime;
                    pq.add(new int[]{nr, nc, newTime, nextCost });
                }
            }
        }
        return -1;
    }
}