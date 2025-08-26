class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int area=0;
        double maxDiag=0;
        for(int[] rect:dimensions){
            double diag=Math.sqrt((rect[0]*rect[0])+(rect[1]*rect[1]));
            if(diag>maxDiag){
                area=rect[0]*rect[1];
                maxDiag=diag;
            }
            else if(diag==maxDiag) {
                area = Math.max(rect[0]*rect[1], area);
            }
        }
        return area;
    }
}