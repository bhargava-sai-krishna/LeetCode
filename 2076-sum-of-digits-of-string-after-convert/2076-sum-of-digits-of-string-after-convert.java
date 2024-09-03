class Solution {
    public int getLucky(String s, int k) {
        int sum=0;
        String temp="";
        for(char c:s.toCharArray()) {
            temp+=c-'a'+1;
        }
        while(k>0) {
            int temp1=0;
            for(char c:temp.toCharArray()) {
                temp1+=c-'0';
            }
            temp=Integer.toString(temp1);
            k--;
        }
        return Integer.parseInt(temp);
    }
}
