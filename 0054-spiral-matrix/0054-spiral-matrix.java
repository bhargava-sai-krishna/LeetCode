class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] directions={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i=0, j=0, m=matrix.length, n=matrix[i].length;
        int d=0;
        List<Integer> ans=new ArrayList<>();
        boolean[][]visited=new boolean[m][n];
        for(int k=0;k<m*n;k++){
            ans.add(matrix[i][j]);
            visited[i][j]=true;
            int ni=i+directions[d][0], nj=j+directions[d][1];
            if(ni<0 || nj<0 || ni>=m || nj>=n || visited[ni][nj]){
                d=(d+1)%4;
                ni=i+directions[d][0];
                nj=j+directions[d][1];
            }
            i=ni;j=nj;
        }
        return ans;
    }
}