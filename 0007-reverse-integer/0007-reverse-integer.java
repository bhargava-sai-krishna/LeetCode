class Solution {
    public int reverse(int x) {
        boolean neg=(x>0)?false:true;
        if(neg)
        {
            x=x*-1;
        }
        String s=Integer.toString(x);
        StringBuilder sb=new StringBuilder(s);  
        sb.reverse();
        s=sb.toString();
        int s2;
        try
        {
            s2=Integer.parseInt(s);
        }
        catch(Exception e)
        {
            return 0;
        }
        if(neg)
        {
            return -s2;
        }
        return s2;
    }
}