class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int x:nums){
            set.add(x);
        }

        int x = k;
        while(true){ 
            if(!set.contains(x)) break;
            x+=k;
        }

        return x;
    }
}