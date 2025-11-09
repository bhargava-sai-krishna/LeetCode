class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int maxSoFar=nums[0];
        int maxEnding=nums[0];
        for(int i=1;i<nums.length;i++){
            maxEnding=Math.max(nums[i], maxEnding+nums[i]);
            maxSoFar=Math.max(maxSoFar, maxEnding);
        }
        return maxSoFar;
    }
}