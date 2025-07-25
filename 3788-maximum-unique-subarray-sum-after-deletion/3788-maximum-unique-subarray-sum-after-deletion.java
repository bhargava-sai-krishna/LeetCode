class Solution {
    public int maxSum(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Set<Integer> set=new HashSet<>();
        int sum=0, max=Integer.MIN_VALUE;
        for(int n:nums){
            if(n>max){
                max=n;
            }
            if(!set.contains(n) && n>=0){
                sum+=n;
                set.add(n);
            }
        }
        return sum==0?max:sum;
    }
}