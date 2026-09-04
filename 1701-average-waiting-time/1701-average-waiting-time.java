class Solution {
    public double averageWaitingTime(int[][] customers) {
        long x = 0;
        long sum = 0;

        for(int i=0; i<customers.length; i++){
            int[] y = customers[i];
            x = Math.max(x, y[0]);
            x+=y[1];
            sum+=(x-y[0]);
        }

        return (double)sum/customers.length;
    }
}