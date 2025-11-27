class Solution {
    public static long maxSubarraySum(int[] nums, int k) {
        long prefixSum=0;
        long subMax=Long.MIN_VALUE;
        long[] minSoFar=new long[k];
        Arrays.fill(minSoFar, Long.MAX_VALUE/2);
        minSoFar[(k-1)%k]=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            subMax=Math.max(subMax, prefixSum-minSoFar[i%k]);
            minSoFar[i%k]=Math.min(minSoFar[i%k], prefixSum);
        }
        return subMax;
    }
}