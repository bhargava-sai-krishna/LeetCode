class Solution {
    private static final int MOD=1000000007;
    public int peopleAwareOfSecret(int n,int delay,int forget){
        long[] dp=new long[n+1];
        dp[1]=1;
        long share=0;
        for(int i=2;i<=n;i++){
            if(i-delay>=1) share=(share+dp[i-delay])%MOD;
            if(i-forget>=1) share=(share-dp[i-forget]+MOD)%MOD;
            dp[i]=share;
        }
        long ans=0;
        for(int i=n-forget+1;i<=n;i++){
            if(i>=1) ans=(ans+dp[i])%MOD;
        }
        return (int)ans;
    }
}
