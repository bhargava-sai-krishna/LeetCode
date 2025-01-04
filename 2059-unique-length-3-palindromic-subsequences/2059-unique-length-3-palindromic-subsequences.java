class Solution {
    public int countPalindromicSubsequence(String s) {
        int count=0;
        Set<Character> letters=new HashSet<>();
        for(char c:s.toCharArray()){
            letters.add(c);
        }
        for(char c:letters){
            int i=-1;
            int j=0;
            for(int k=0;k<s.length();k++){
                if(s.charAt(k)==c){
                    if(i==-1){
                        i=k;
                    }
                    j=k;
                }
            }
            Set<Character>between=new HashSet<>();
            for(int k=i+1;k<j;k++){
                between.add(s.charAt(k));
            }
            count+=between.size();
        }
        return count;
    }
}