class Solution {
    public int countPartitions(int[] nums) {
        int totSum=0;
        for(int i=0;i<nums.length;i++){
            totSum+=nums[i];
        }
        if((totSum & 1)==0){
            return nums.length-1;
        }
        return 0;
    }
}