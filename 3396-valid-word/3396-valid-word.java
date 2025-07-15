import java.util.regex.*;

class Solution {
    public boolean isValid(String word) {
        if(word.length()<3) return false;
        if(!word.matches("[a-zA-Z0-9]+")) return false;
        if(!Pattern.compile("[aeiouAEIOU]").matcher(word).find()) return false;
        if(!Pattern.compile("[b-df-hj-np-tv-zB-DF-HJ-NP-TV-Z]").matcher(word).find()) return false;
        return true;
    }
}
