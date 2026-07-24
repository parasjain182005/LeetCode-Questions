class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Arrays.sort(nums);

        int x = nums[nums.length-1];
        int c = 1;
        while(c<=x) c = c<<1;


        boolean[] arr = new boolean[c];
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                arr[nums[i]^nums[j]] = true;
            }
        }

        boolean[] arr1 = new boolean[c];
        for(int i=0; i<nums.length; i++){
            if(i+1<nums.length && nums[i]==nums[i+1]) continue;
            for(int j=0; j<arr.length; j++){
                if(arr[j]) arr1[j^nums[i]] = true;
            }
        }

        int ans = 0;
        for(boolean a:arr1){
            if(a) ans++;
        }
        return ans;
    }
}