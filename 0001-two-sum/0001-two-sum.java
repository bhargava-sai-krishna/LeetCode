class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len=nums.length;
        int[] res=new int[2];
        int flag=0;
        for(int i=0;i<len;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                if(nums[i]+nums[j]==target && flag==0)
                {
                    res[0]=i;
                    res[1]=j;
                    flag=1;
                }
            }
        }
        Arrays.sort(res);
        return res;
    }
}