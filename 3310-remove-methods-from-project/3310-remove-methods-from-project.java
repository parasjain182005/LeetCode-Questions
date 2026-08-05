class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0; i<n; i++) l.add(new ArrayList<>());

        for(int[] x:invocations){
            l.get(x[0]).add(x[1]);
        }

        int[] vis = new int[n];
        vis[k]=1;     
        Queue<Integer> q = new LinkedList<>();
        q.add(k);

        while(!q.isEmpty()){
            int x = q.poll();
            for(int y:l.get(x)){
                if(vis[y]!=1){
                    q.add(y);
                    vis[y]=1;
                }
            }
        }

        for(int[] x:invocations){
            if(vis[x[0]]!=1 && vis[x[1]]!=0){
                List<Integer> list = new ArrayList<>();
                for(int i=0; i<n; i++){
                    list.add(i);
                }
                return list;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(vis[i]!=1) ans.add(i);
        }
        return ans;
    }
}