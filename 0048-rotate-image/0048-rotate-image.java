class Solution {
    public void rotate(int[][] matrix) {
        int[][] temp=new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                temp[i][j]=matrix[i][j];
            }
        }
        int ind1=0,ind2=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=matrix.length-1;j>=0;j--)
            {
                matrix[ind1][ind2++]=temp[j][i];
            }
            ind1=ind1+1;
            ind2=0;
        }
    }
}