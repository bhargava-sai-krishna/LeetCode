class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int rows=matrix.length, cols=matrix[0].length;
        int[] heights=new int[cols];
        int maxArea=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                heights[j] = (matrix[i][j]=='1') ? heights[j]+1 : 0;
            }
            maxArea=Math.max(maxArea,largestArea(heights));
        }
        return maxArea;
    }
    private int largestArea(int[] heights){
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;
        int n=heights.length;
        for(int i=0;i<=n;i++){
            int h=(i==n)?0:heights[i];
            while(!stack.isEmpty() && h<heights[stack.peek()]){
                int height=heights[stack.pop()];
                int width=stack.isEmpty()?i:i-stack.peek()-1;
                maxArea=Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}