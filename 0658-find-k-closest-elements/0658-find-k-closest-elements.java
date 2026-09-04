class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> l = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(arr[a[1]], arr[b[1]]);
        });

        for(int i=0; i<arr.length; i++){
            pq.add(new int[]{Math.abs(x-arr[i]), i});
        }

        while(k>0){
            int[] y = pq.poll();
            l.add(arr[y[1]]);
            k--;
        }

        Collections.sort(l);
        return l;
    }
}