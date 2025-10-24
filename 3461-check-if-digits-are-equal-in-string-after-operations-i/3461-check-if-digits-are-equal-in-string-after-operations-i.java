class Solution {
    public boolean hasSameDigits(String s) {
        if(s.length()==2){
            return s.charAt(0)==s.charAt(1);
        }
        String modefied=new String();
        for(int i=0;i<s.length()-1;i++){
            modefied+=String.valueOf(((s.charAt(i)-'0')+(s.charAt(i+1)-'0'))%10);
        }
        return hasSameDigits(modefied);
    }
}