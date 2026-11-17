
class Solution {
    public int minReorder(int n, int[][] connections) {
        int ans = 0;

        List<List<int[]>> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            l.add(new ArrayList<>());
        }

        for (int[] x : connections) {
            l.get(x[0]).add(new int[]{x[1], 1});
            l.get(x[1]).add(new int[]{x[0], 0});
        }

        int[] vis = new int[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = 1;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int[] y : l.get(x)) {
                int node = y[0];
                int dir = y[1];

                if (vis[node] == 0) {
                    vis[node] = 1;
                    q.add(node);

                    if (dir == 1) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
