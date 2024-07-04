class Solution {
    public void reverseString(char[] s) {
        char x;
        int i=0,r=s.length-1;
        while(i<=r){
            x=s[i];
            s[i]=s[r];
            s[r]=x;
            i++;
            r--;
        }
    }
}