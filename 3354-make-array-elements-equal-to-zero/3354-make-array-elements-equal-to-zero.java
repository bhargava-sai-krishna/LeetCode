class Solution {
    public int countValidSelections(int[] nums) {
        int count=0;
        int nonZeros=0;
        int n=nums.length;
        for(int i:nums){
            if(i>0){
                nonZeros++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                if(isValid(nums, nonZeros, i, false, n)){
                    count++;
                }
                if(isValid(nums, nonZeros, i, true, n)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isValid(int[] nums, int nonZeros, int start, boolean direction, int n){
        int curr=start;
        int[] temp=nums.clone();
        while(nonZeros>0 && curr>=0 && curr<n){
            if(temp[curr]>0){
                temp[curr]--;
                direction=!direction;
                if(temp[curr]==0){
                    nonZeros--;
                }
            }
            curr+=(direction)?1:-1;
        }
        return nonZeros==0;
    }
}