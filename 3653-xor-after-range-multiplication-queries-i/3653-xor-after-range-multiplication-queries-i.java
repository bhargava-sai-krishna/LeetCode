class Solution {
    private static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] query : queries) {
            int idx = query[0];
            while(idx <= query[1]) {
                nums[idx] = (int) (((long)nums[idx] * query[3]) % MOD);
                idx += query[2];
            }
        }

        int xor = nums[0];

        for(int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        return xor;
    }
}