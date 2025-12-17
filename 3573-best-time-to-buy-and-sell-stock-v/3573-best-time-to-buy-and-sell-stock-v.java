class Solution {
    class state{
        long maxProfit, buyHold, sellHold;
        state(long p, long b, long s){
            maxProfit=p;
            buyHold=b;
            sellHold=s;
        }
    }
    public long maximumProfit(int[] prices, int k) {
        int firstPrice=prices[0];
        state[] dp=new state[k+1];
        for(int i=0;i<=k;i++){
            dp[i]=new state(0, -firstPrice, firstPrice);
        }
        int n=prices.length;
        for(int i=1;i<n;i++){
            int currPrice=prices[i];
            for(int trans=k;trans>0;trans--){
                long pervProfit=dp[trans-1].maxProfit;
                dp[trans].maxProfit=Math.max(dp[trans].maxProfit, Math.max(dp[trans].buyHold+currPrice, dp[trans].sellHold-currPrice));
                dp[trans].buyHold=Math.max(dp[trans].buyHold, pervProfit-currPrice);
                dp[trans].sellHold=Math.max(dp[trans].sellHold, pervProfit+currPrice);
            }
        }
        return dp[k].maxProfit;
    }
}