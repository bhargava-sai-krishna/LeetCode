class Solution {
    public String compressedString(String word) {
        String ans="";
        int cnt=1, n=word.length();
        char ch=word.charAt(0);
        for(int i=1;i<n;i++){
            if(word.charAt(i)==ch && cnt<9){
                cnt++;
            }
            else{
                ans+=Integer.toString(cnt)+ch;
                ch=word.charAt(i);
                cnt=1;
            }
        }
        ans+=Integer.toString(cnt)+ch;
        return ans;
    }
}