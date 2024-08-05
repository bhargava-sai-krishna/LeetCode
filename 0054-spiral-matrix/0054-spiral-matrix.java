class Solution {
    public void spiral(int[][] matrix, int m, int n, List<Integer> ans, int r, int c, int dr, int dc){
        if(m==0 || n==0){
            return;
        }
        for(int i=1;i<=n;i++){
            r=r+dr;
            c=c+dc;
            ans.add(matrix[r][c]);
        }
        spiral(matrix, n, m-1, ans, r, c, dc, -dr);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        spiral(matrix,matrix.length, matrix[0].length, ans, 0,-1,0,1);
        return ans;
    }
}