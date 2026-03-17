class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for(int i = 1; i < n; i++) {
            int temp = maxProd;
            maxProd = Math.max(nums[i], 
                            Math.max(maxProd * nums[i], 
                                minProd * nums[i]));

            minProd = Math.min(nums[i], 
                            Math.min(temp * nums[i], 
                            minProd * nums[i]));
            
            result = Math.max(maxProd, result);
        }

        return result;
    }
}