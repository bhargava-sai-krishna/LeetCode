class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int left = 0;
        for(int i = 0; i < n; i++) {
            ans[i] = left;
            left += nums[i];
        }

        int right = 0;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] = Math.abs(ans[i] - right);
            right += nums[i];
        }
        return ans;
    }
}