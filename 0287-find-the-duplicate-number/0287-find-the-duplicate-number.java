class Solution {
    public int findDuplicate(int[] nums) {
        int hare=nums[0];
        int tortise=nums[0];
        while(true){
            tortise=nums[tortise];
            hare=nums[nums[hare]];
            if(tortise==hare){
                break;
            }
        }
        int temp=nums[0];
        while(tortise!=temp){
            tortise=nums[tortise];
            temp=nums[temp];
        }
        return tortise;
    }
}