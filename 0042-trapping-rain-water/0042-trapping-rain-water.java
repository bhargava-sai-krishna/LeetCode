class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int max_l_height=height[left];
        int max_r_height=height[right];
        int water=0;
        while(left<right){
            if(max_l_height<max_r_height){
                left++;
                max_l_height=Math.max(max_l_height,height[left]);
                water=water+max_l_height-height[left];
            }
            else{
                right--;
                max_r_height=Math.max(max_r_height,height[right]);
                water=water+max_r_height-height[right];
            }
        }
        return water;
    }
}