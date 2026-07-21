class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        List<List<Integer>> sum = new ArrayList<>();

        for(int i=0; i<vals.length; i++){
            sum.add(new ArrayList<>());            
        } 

        for(int[] x:edges){
            sum.get(x[0]).add(vals[x[1]]);
            sum.get(x[1]).add(vals[x[0]]);
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0; i<vals.length; i++){

            Collections.sort(sum.get(i));

            int x = sum.get(i).size();
            int y=vals[i], c=0;
            for(int j=x-1; j>=0 && c<k; j--){
                if (sum.get(i).get(j) <= 0) break;
                y+=sum.get(i).get(j);
                c++;
            }
            ans = Math.max(ans, y);
        }
        return ans;        
    }
}