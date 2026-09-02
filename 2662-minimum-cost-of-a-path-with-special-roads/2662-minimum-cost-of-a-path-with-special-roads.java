class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{start[0], start[1], 0});  

        Map<String, Integer> map = new HashMap<>();
        map.put(start[0] + "," + start[1], 0);      

        while(!pq.isEmpty()){
            int[] p = pq.poll();

            String current = p[0] + "," + p[1];
            if (p[2] != map.get(current)) {
                continue;
            }

            if(p[0]==target[0] && p[1]==target[1]) return p[2];

            for(int[] x:specialRoads){
                int y = Math.abs(p[0]-x[0])+Math.abs(p[1]-x[1]);

                String next = x[2] + "," + x[3];
                int nc = p[2]+x[4]+y;

                if (!map.containsKey(next)|| nc < map.get(next)) {

                    map.put(next, nc);
                    pq.add(new int[]{x[2], x[3], nc});
                }
            }

            int z = Math.abs(p[0]-target[0])+Math.abs(p[1]-target[1]);

            String next = target[0] + "," + target[1];
            int nc = p[2]+z;

            if (!map.containsKey(next)|| nc < map.get(next)) {

                map.put(next, nc);
                pq.add(new int[]{target[0], target[1], nc});
            }
        }
        return 0;
    }
}