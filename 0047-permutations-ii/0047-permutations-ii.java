class Solution {
    Set<List<Integer>> uniqueSet=new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        formalPermutation(0, nums);
        return new ArrayList<>(uniqueSet);
    }
    private void formalPermutation(int index, int[] nums){
        if(index==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int i:nums){
                list.add(i);
            }
            uniqueSet.add(list);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums, index, i);
            formalPermutation(index+1, nums);
            swap(nums, index, i);
        }
    }
    private void swap(int[] nums, int i, int j){
        if(i==j){
            return;
        }
        nums[i]=nums[i]+nums[j];
        nums[j]=nums[i]-nums[j];
        nums[i]=nums[i]-nums[j];
    }
}