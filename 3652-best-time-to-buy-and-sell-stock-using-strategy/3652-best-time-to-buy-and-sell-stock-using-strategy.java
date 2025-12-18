class Solution {
    public long maxProfit(int[] prices,int[] strategy,int k){
        int n=prices.length;
        int half=k/2;

        long[] profitPS=new long[n+1];
        long[] pricePS=new long[n+1];

        for(int i=0;i<n;i++){
            profitPS[i+1]=profitPS[i]+(long)prices[i]*strategy[i];
            pricePS[i+1]=pricePS[i]+prices[i];
        }

        long maxProfit=profitPS[n]; // original strategy

        for(int i=0;i<=n-k;i++){
            long oldWindow=profitPS[i+k]-profitPS[i];
            long newWindow=pricePS[i+k]-pricePS[i+half];

            long curr=profitPS[n]-oldWindow+newWindow;
            maxProfit=Math.max(maxProfit,curr);
        }
        return maxProfit;
    }
}
