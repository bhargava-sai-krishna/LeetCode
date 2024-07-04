class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n=0;
        for(int i:arr){
            if(i%2!=0){
                if(n==2){
                    return true;
                }
                n++;
            }
            if(i%2==0){
                n=0;
            }
        }
        System.gc();
        return false;
    }
}