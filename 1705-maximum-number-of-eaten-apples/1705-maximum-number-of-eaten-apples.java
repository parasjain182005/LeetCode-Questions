class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        int n = apples.length;
        int ans  = 0;
        int x = 0;

        while(x < n || !pq.isEmpty()){
            
            if(x<n && apples[x]>0){
                int day = x+days[x];
                pq.add(new int[]{day, apples[x]});
            }

            while(!pq.isEmpty() && pq.peek()[0]==x){
                pq.poll();
            }

            if(!pq.isEmpty()){
                int[] a = pq.peek();

                a[1]--;
                ans++;

                if(a[1] == 0){
                    pq.poll();
                }
            }
            x++;            
        }
        return ans;
    }
}