class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b) -> b[1]-a[1]);

        for(int i=0; i<nums1.length; i++){
            p.add(new int[]{nums1[i], nums2[i]});
        }

        for(int i=0; i<nums1.length; i++){
            int[] x = p.poll();
            nums1[i] = x[0];
            nums2[i] = x[1];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a,b) -> a-b);        
        long ans = 0;
        long sum = 0;

        for(int i=0; i<nums1.length; i++){
            pq.add(nums1[i]);
            sum+=nums1[i];

            if(pq.size()>k) sum-=pq.poll();
            if(pq.size() == k) ans = Math.max(ans, (sum*nums2[i]));
        } 

        return ans;       
    }
}