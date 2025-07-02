class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        return rle(countAndSay(n-1));
    }
    private String rle(String s){
        String res=new String();
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            else{
                res+=count;
                res+=s.charAt(i-1);
                count=1;
            }
        }
        res+=count;
        res+=s.charAt(s.length()-1);
        return res;
    }
}