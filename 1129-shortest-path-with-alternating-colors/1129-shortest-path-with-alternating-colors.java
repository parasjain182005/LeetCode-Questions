class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges){
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0]=0;

        List<List<int[]>> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(new ArrayList<>());

        for(int[] x:redEdges){
            list.get(x[0]).add(new int[]{x[1], 0});
        }
        for(int[] x:blueEdges){
            list.get(x[0]).add(new int[]{x[1], 1});
        }

        boolean[][] vis = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0,0,0});
        q.add(new int[]{0,0,1});
        vis[0][0] = true;
        vis[0][1] = true;

        while(!q.isEmpty()){
            int[] x = q.poll();
            ans[x[0]] = Math.min(ans[x[0]],x[1]);

            for(int[] y:list.get(x[0])){
                if(!vis[y[0]][y[1]] && y[1]!=x[2]){
                    q.add( new int[]{y[0], x[1]+1, y[1]});
                    vis[y[0]][y[1]] = true;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(ans[i]==Integer.MAX_VALUE) ans[i]=-1;
        }
        return ans;
    }
}