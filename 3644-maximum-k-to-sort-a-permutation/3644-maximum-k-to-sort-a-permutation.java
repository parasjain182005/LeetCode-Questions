class Solution {
    public int sortPermutation(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=i) list.add(i);
        }
        if(list.size()==0) return 0;
        int k=list.get(0);
        for(int i=1; i<list.size(); i++){
            k&=list.get(i);
        }
        return k;
    }
}