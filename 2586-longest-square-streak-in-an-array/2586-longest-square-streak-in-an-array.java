class Solution {
    public int longestSquareStreak(int[] nums) {
        int ls=0;
        Set<Integer> uniq=new HashSet<>();
        for(int n:nums){
            uniq.add(n);
        }
        for(int s:nums){
            int currst=0;
            long curr=s;
            while(uniq.contains((int)curr)){
                currst++;
                if(curr*curr>1e5){
                    break;
                }
                curr=curr*curr;
            }
            ls=Math.max(ls, currst);
        }
        return ls<2?-1:ls;
    }
}