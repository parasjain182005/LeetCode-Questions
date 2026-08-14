class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length + nums2.length;
        List<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<nums1.length; i++){
            arr.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; i++){
            arr.add(nums2[i]);
        }
        Collections.sort(arr);
        double result;
        if(x%2==0){
            result = (arr.get(x/2) + arr.get(x/2 - 1))/2.0;
        }
        else{
            result = arr.get(x/2);
        }
        return result;
    }
}