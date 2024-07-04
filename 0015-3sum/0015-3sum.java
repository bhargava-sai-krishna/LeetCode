class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>>ans=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
            int left=i+1;
            int right=nums.length-1;
            while(left<right)
            {
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0)
                {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left=left+1;
                    right=right-1;
                }
                else if(sum<0)
                {
                    left=left+1;
                }
                else
                {
                    right=right-1;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}