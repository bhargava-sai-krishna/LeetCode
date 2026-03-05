class Solution {
    private static int solve(int[] nums, int start, int end) {

        int currTake = 0;
        int currNotTake = 0;

        for(int i = start; i <= end; i++) {
            int curr = Math.max(currTake, currNotTake + nums[i]);
            currNotTake = currTake;
            currTake = curr;
        }

        return currTake;
    }
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        return Math.max(solve(nums, 0, n - 2), solve(nums, 1, n - 1));
    }
}