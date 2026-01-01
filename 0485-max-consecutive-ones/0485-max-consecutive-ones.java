class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0, count=0;
        while(i<nums.length){
            int curr=0;
            while(i<nums.length && nums[i]!=0){
                curr++;
                i++;
            }
            count=Math.max(count, curr);
            i++;
        }
        return count;
    }
}