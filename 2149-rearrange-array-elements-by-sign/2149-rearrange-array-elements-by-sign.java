class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> posStack=new LinkedList<>();
        Queue<Integer> negStack=new LinkedList<>();
        for(int i:nums){
            if(i>=0){
                posStack.add(i);
            }
            else{
                negStack.add(i);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=posStack.poll();
            }
            else{
                nums[i]=negStack.poll();
            }
        }
        return nums;
    }
}