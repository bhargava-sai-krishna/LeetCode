class Solution {
    public static boolean checkPrefix(String s, String pref){
        if(s.length()<pref.length()){
            return false;
        }
        for(int i=0;i<pref.length();i++){
            if(s.charAt(i)!=pref.charAt(i)){
                return false;
            }
        }
        return true;
    } 
    public int prefixCount(String[] words, String pref) {
        int count=0;
        for(String word:words){
            if(word.charAt(0)==pref.charAt(0)){
                if(checkPrefix(word, pref)){
                    count++;
                }
            }
        }
        return count;
    }
}