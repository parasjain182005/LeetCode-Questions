class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int x : nums){
            list1.add(x);
        }
        int x = nums[0];
        while(x<nums[nums.length-1]){
            if(!list1.contains(x)) list2.add(x);
            x++;
        }
        return list2;
    }
}