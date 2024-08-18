class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals("") && p.equals("")){
            return true;
        }
        if(p.equals("")){
            return false;
        }
        int rows = s.length();
        int cols = p.length();
        boolean[][] dp = new boolean[rows + 1][cols + 1];
        dp[0][0] = true;
        for(int i = 2; i <= cols; i++){
            if(p.charAt(i - 1) == '*'){
                dp[0][i] = dp[0][i - 2];
            }
        }
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= cols; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 2];
                    if(p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)){
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[rows][cols];
    }
}
