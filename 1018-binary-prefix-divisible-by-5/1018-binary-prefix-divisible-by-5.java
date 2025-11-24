class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans=new ArrayList<>();
        for(int i:nums){
            if(i==0){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}