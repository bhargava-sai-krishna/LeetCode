class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l=0, r=0;
        HashSet<Integer> set=new HashSet<>();
        int maxSum=0, currSum=0;
        while(r<nums.length){
            while(set.contains(nums[r])){
                set.remove(nums[l]);
                currSum-=nums[l];
                l++;
            }
            set.add(nums[r]);
            currSum+=nums[r];
            maxSum=Math.max(maxSum, currSum);
            r++;
        }
        return maxSum;
    }
}