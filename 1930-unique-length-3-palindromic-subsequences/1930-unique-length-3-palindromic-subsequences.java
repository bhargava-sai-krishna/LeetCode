class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] minMax=new int[52];
        int n=s.length();
        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'a';
            if(minMax[c]==0){
                minMax[c]=i+1;
            }
            else{
                minMax[c+26]=i;
            }
        }
        int total=0;
        for(int i=0;i<26;i++){
            int min=minMax[i];
            int max=minMax[i+26];
            int mask=0;
            for(int j=min;j<max;j++){
                int ind=s.charAt(j)-'a';
                if((mask>>ind&1)==0){
                    mask|=(1<<ind);
                    total++;
                }
            }
        }
        return total;
    }
}