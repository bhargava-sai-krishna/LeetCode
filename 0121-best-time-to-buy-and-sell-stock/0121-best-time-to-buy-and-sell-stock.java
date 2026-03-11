class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minCost = prices[0];
        int n = prices.length;

        for(int i = 0; i < n; i++) {
            if(minCost > prices[i]) {
                minCost = prices[i];
            }

            profit = Math.max(profit, prices[i] - minCost);
        }

        return profit;
    }
}