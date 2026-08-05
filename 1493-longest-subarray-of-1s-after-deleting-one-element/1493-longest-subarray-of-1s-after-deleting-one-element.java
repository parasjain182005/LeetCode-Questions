class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int x0=0,x1=0,j=0;
        int x = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1) x1++;
            else{
                x++;
                x0++;
            }

            while(x0>1){
                x++;;
                if(nums[j]==1) x1--;
                else x0--;
                j++;
            }
            
            ans = Math.max(ans, x1);
        }
        if(x==0) ans--;
        return ans;
    }
}