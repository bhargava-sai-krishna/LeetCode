import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[i] + nums[mid] < lower) {
                    left = mid + 1;
                } 
                else {
                    right = mid - 1;
                }
            }
            int start = left;
            left = start;
            right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[i] + nums[mid] > upper) {
                    right = mid - 1;
                } 
                else {
                    left = mid + 1;
                }
            }
            int end = right;
            if (start <= end) {
                ans += (end - start + 1);
            }
        }

        return ans;
    }
}
