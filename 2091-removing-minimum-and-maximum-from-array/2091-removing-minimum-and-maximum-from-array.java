class Solution {
    public int minimumDeletions(int[] nums) {
        int a=Integer.MAX_VALUE,b=0;
        int x=Integer.MIN_VALUE,y=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<a){
                a=nums[i];
                b=i;
            }
            if(nums[i]>x){
                x=nums[i];
                y=i;
            }
        }
        int c=Math.max(b,y)+1;
        int d=nums.length-Math.min(b,y);
        int e=Math.min(b,y) + (nums.length-Math.max(b,y)) + 1;
        return Math.min(c,Math.min(d,e));
    }
}