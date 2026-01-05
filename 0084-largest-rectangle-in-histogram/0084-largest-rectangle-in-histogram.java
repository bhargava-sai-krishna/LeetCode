class Solution {
    public int largestRectangleArea(int[] heights) {
        int area=0;
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int bar=st.pop();
                int pse=st.isEmpty()?-1:st.peek();
                int nse=i;
                area=Math.max(area, heights[bar]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int bar=st.pop();
            int pse=st.isEmpty()?-1:st.peek();
            int nse=n;
            area=Math.max(area, heights[bar]*(nse-pse-1));
        }
        return area;
    }
}