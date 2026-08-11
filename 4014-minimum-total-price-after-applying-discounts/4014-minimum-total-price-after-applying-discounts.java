class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        double ans = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int i=prices.length-1, j=discounts.length-1;

        while(i>=0){
            if(j>=0){
                double x = (double)((prices[i]*(100-discounts[j]))/100.0);
                ans+=x;
                j--;
            }
            else ans+=prices[i];
            i--;
        }
        return ans;
    }
}