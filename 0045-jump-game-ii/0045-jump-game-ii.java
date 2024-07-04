class Solution {
    public int jump(int[] nums) {
        for(int i=1;i<nums.length;i++)
        {
            nums[i]=Math.max(nums[i]+i,nums[i-1]);
        }
        int jumps=0;
        int i;
        for(i=0;i<nums.length-1;)
        {
            jumps=jumps+1;
            i=nums[i];
        }
        return jumps;
    }
}