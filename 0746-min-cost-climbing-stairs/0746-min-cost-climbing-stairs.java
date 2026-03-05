class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] prices = new int[n];
        prices[0] = cost[0];
        prices[1] = cost[1];

        for(int i = 2; i < n; i++) {
            prices[i] = cost[i] + Math.min(prices[i - 1], prices[i - 2]);
        }

        return Math.min(prices[n - 1], prices[n - 2]);
    }
}