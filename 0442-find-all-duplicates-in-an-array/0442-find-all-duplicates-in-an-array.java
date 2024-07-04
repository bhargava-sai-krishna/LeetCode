class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int temp=(nums[i]>0)?nums[i]:nums[i]*-1;
            if(nums[temp-1]<0){
                ans.add(temp);
            }
            else{
                nums[temp-1]=nums[temp-1]*-1;
            }
        }
        return ans;
    }
}