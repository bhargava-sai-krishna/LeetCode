class Solution {
    public String vowels="aeiou"; 
    public int countVowels(String s){
        int count=0;
        for(char c:s.toCharArray()){
            if(vowels.indexOf(c)!=-1){
                count++;
            }
        }
        return count;
    }
    public boolean doesAliceWin(String s) {
        int vowelsCount=countVowels(s);
        if(vowelsCount==0){
            return false;
        }
        return true;
    }
}