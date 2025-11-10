class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            while(stack.peek()>nums[i]){
                stack.pop();
                ans++;
            }
            if(stack.peek()!=nums[i]){
                stack.push(nums[i]);
            }
        }
        return ans+stack.size()-1;
    }
}