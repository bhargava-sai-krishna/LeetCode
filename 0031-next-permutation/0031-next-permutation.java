class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length, i=n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=n-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            nums[i]=nums[i]+nums[j];
            nums[j]=nums[i]-nums[j];
            nums[i]=nums[i]-nums[j];
        }
        reverse(nums, i+1, n-1);
    }
    public void reverse(int[] nums, int start, int end){
        while(start<end){
            nums[start]=nums[start]+nums[end];
            nums[end]=nums[start]-nums[end];
            nums[start]=nums[start]-nums[end];
            start++;
            end--;
        }
    }
}