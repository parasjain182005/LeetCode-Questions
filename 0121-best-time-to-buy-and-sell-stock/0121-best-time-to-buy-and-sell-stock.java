class Solution {
    public int maxProfit(int[] arr) {
        int buyPrice = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0; i<arr.length; i++){
            if(buyPrice < arr[i]){
                int profit = arr[i] - buyPrice;
                max = Math.max(profit, max);
            }
            else{
                buyPrice = arr[i];
            }
        }
        return max;
    }
}