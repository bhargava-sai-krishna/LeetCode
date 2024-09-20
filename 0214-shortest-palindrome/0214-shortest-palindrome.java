class Solution {
    public String shortestPalindrome(String s) {
        int count=kmp(new StringBuilder(s).reverse().toString(), s);
        return new StringBuilder(s.substring(count)).reverse().toString()+s;
    }
    public int kmp(String s, String pattern){
        String n=pattern+'_'+s;
        int[] lps=new int[n.length()];
        int i=1, k=0;
        while(i<n.length()){
            if(n.charAt(i)==n.charAt(k)){
                k++;
                lps[i]=k;
                i++;
            }
            else{
                if(k>0){
                    k=lps[k-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps[n.length()-1];
    }
}