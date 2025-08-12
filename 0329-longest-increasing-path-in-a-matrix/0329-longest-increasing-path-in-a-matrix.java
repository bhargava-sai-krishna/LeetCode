class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int[][] dp=new int[m][n];
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res=Math.max(res, dfs(matrix, dp, i, j, m, n));
            }
        }
        return res;
    }
    private int dfs(int[][] matrix, int[][] dp, int i, int j, int m, int n){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int max=1;
        int[][] directions={{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] direction:directions){
            int x=i+direction[0], y=j+direction[1];
            if(x>=0 && x<m && y>=0 && y<n && matrix[x][y]>matrix[i][j]){
                max=Math.max(max, 1+dfs(matrix, dp, x, y, m, n));
            }
        }
        dp[i][j]=max;
        return max;
    }
}