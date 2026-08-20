class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int i=0, j=n-1;
        arr[0] = nums[0];
        arr[j] = nums[1];

        for(int k=2; k<n; k++){
            if(arr[i]>arr[j]){
                i++;
                arr[i] = nums[k];
            }
            else{
                j--;
                arr[j] = nums[k];
            }
        }

        i=j;
        j=n-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return arr;
    }
}