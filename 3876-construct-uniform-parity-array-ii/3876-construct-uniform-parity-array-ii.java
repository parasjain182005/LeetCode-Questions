class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd=0, even=0;
        for(int x:nums1){
            if(x%2==0) even++;
            else odd++;
        }
        if(odd==nums1.length || even==nums1.length) return true;
        Arrays.sort(nums1);
        if(nums1[0]%2==0) return false;
        return true;
    }
}