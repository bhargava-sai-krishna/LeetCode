class Solution {
    public int maxSubArray(int[] nums) {
        int currSum=nums[0], maxSum=nums[0], n=nums.length;
        for(int i=1;i<n;i++){
            currSum=Math.max(nums[i], currSum+nums[i]);
            maxSum=Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}