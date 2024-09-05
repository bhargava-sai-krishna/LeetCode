class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int totalSize=n+rolls.length;
        int totalSum=mean*totalSize;
        int[] ans=new int[n];
        for(int i:rolls){
            totalSum=totalSum-i;
        }
        if(totalSum<n || totalSum>n*6){
            return new int[0];
        }
        else{
            int avg=totalSum/n;
            int rem=totalSum%n;
            for(int i=0;i<n;i++){
                if(i<rem){
                    ans[i]=avg+1;
                }
                else{
                    ans[i]=avg;
                }
            }
        }
        return ans;
    }
}