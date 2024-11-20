class Solution {
    public int takeCharacters(String s, int k) {
        int[] count=new int[3];
        int n=s.length();
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        if(count[0]<k || count[1]<k || count[2]<k){
            return -1;
        }
        int[] win=new int[3];
        int l=0, max=0;
        for(int r=0;r<n;r++){
            win[s.charAt(r)-'a']++;
            while(l<=r && (count[0]-win[0]<k || count[1]-win[1]<k || count[2]-win[2]<k)){
                win[s.charAt(l)-'a']--;
                l++;
            }
            max=Math.max(max, r-l+1);
        }
        return n-max;
    }
}