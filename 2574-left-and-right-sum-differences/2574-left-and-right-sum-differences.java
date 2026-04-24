class Solution {
    public int[] leftRightDifference(int[] nums) {
        int right = 0;
        int n = nums.length;
        for (int num : nums) {
            right += num;
        }
        int  left=0;
        int t=0;
        for (int i = 0; i < n; i++) {
            t=nums[i];
            right = right-t;
            nums[i] = Math.abs(left-right);
            left += t;
        }
        return nums;
    }
}