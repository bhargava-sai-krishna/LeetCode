class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.isEmpty() || n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            int ones = s.charAt(i - 1) - '0';
            int tens = Integer.parseInt(s.substring(i - 2, i));

            if(ones != 0) {
                dp[i] += dp[i - 1];
            }

            if(tens >= 10 && tens <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}