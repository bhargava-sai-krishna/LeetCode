class Solution {
    public static final int MOD=1000000007;
    public int numberOfWays(int n, int x) {
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int p=(int)Math.pow(i, x);
            if(p>n){
                break;
            }
            for(int sum=n;sum>=p;sum--){
                dp[sum]=(dp[sum]+dp[sum-p])%MOD;
            }
        }
        return dp[n];
    }
}