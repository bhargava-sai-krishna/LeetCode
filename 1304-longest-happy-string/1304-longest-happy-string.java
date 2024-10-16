class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int ca=0, cb=0, cc=0;
        int max=a+b+c, i=0;
        String ans="";
        while(i<max){
            if(ca!=2 && a>=b && a>=c || a>0 && (cb==2||cc==2)){
                ans+="a";
                ca++;
                cb=0;
                cc=0;
                a--;
            }
            else if(cb!=2 && a<=b && b>=c || b>0 && (ca==2||cc==2)){
                ans+="b";
                cb++;
                ca=0;
                cc=0;
                b--;
            }
            else if(cc!=2 && a<=c && b<=c || c>0 && (ca==2||cb==2)){
                ans+="c";
                cc++;
                cb=0;
                ca=0;
                c--;
            }
            i++;
        }
        return ans;
    }
}