class Solution {
    int totalWays=0;
    public void calculate(int[] nums, int currInd, int currSum, int target){
        if(currInd==nums.length){
            if(currSum==target){
                totalWays++;
            }
        }
        else{
            calculate(nums, currInd+1, currSum+nums[currInd], target);
            calculate(nums, currInd+1, currSum-nums[currInd], target);
        }
    }
    public int findTargetSumWays(int[] nums, int target) {
        calculate(nums, 0, 0, target);
        return totalWays;
    }
}