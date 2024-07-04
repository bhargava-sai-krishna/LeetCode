class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int max=0;
        int i=0,j=n-1;
        while(i<j)
        {
            int area=(j-i)*Math.min(height[i],height[j]);
            if(max<area)
            {
                max=area;
            }
            if(height[i]<height[j])
            {
                i=i+1;
            }
            else if(height[i]>=height[j])
            {
                j=j-1;
            }
        }
        return max;
    }
}