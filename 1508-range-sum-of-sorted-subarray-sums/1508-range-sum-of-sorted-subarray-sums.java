class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1_000_000_007;
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum+=nums[j];
                list.add(sum);
            }
        }

        Collections.sort(list);
        int ans = 0;
        for(int i=left-1; i<right; i++){
            ans+=list.get(i);
            ans%=mod;
        }
        return ans;
    }
}