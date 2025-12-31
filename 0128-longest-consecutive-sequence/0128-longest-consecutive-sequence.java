class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int long_=0;
        for(int i:set){
            if(!set.contains(i-1)){
                int length=1;
                while(set.contains(i+length)){
                    length++;
                }
                long_=Math.max(long_, length);
            }
        }
        return long_;
    }
}