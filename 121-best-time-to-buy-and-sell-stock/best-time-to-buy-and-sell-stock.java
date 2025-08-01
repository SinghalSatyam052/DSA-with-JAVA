class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] profit = new int[n];
        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(prices[i] < min) {
                min = prices[i];

                for(int j = i+1;j<n;j++) profit[i] = Math.max(profit[i],prices[j] - prices[i]);
            }
        }
        int max = profit[0];

        for(int i : profit) max = Math.max(i,max);

        return max;
    }
}