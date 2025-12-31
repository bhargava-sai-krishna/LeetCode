class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;
        int max_l=height[0], max_r=height[r];
        int water=0;
        while(l<r){
            if(max_l<max_r){
                l++;
                max_l=Math.max(max_l, height[l]);
                water+=max_l-height[l];
            }
            else{
                r--;
                max_r=Math.max(max_r, height[r]);
                water+=max_r-height[r];
            }
        }
        return water;
    }
}