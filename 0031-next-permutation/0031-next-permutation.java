class Solution {

    private void swapNumbers(int[] nums, int ind1, int ind2) {
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swapNumbers(nums, start, end);
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = 0;

        for(int i = n - 1; i > 0; i--) {
            if(nums[i-1] < nums[i]) {
                pivot = i;
                break;
            }
        }

        if(pivot == 0) {
            Arrays.sort(nums);
            return;
        }

        int swap = n - 1;

        while(nums[pivot - 1] >= nums[swap]) {
            swap -= 1;
        }

        swapNumbers(nums, pivot - 1, swap);
        reverse(nums, pivot, n - 1);
    }
}