class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int max_temp=0;
        for(int i:nums)
        {
            max_temp = max_temp + i;
            if (max < max_temp) 
            {
                max = max_temp;
            }
            if (max_temp < 0) 
            {
                max_temp = 0;
            }
        }
        return max;
    }
}