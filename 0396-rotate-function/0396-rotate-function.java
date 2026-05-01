class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int numSum = Arrays.stream(nums).sum();
        int f = IntStream.range(0, n)
        .map(i -> i * nums[i])
        .sum();
        int ans = f;
        for(int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            ans = Math.max(ans, f);
        }
        return ans;
    }
}