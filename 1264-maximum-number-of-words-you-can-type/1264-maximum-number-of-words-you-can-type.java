class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words=text.split(" ");
        int count=words.length;
        for(String s:words){
            boolean possible=true;
            for(char c:brokenLetters.toCharArray()){
                if(s.indexOf(c)!=-1){
                    possible=false;
                }
            }
            if(!possible){
                count--;
            }
        }
        return count;
    }
}