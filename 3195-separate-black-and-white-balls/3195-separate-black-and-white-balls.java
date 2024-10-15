class Solution {
    public long minimumSteps(String s) {
        long ans=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                ans+=(long)count;
            }
            else{
                count++;
            }
        }
        return ans;
    }
}