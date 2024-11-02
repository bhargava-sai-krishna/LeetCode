class Solution {
    public boolean isCircularSentence(String sentence) {
        int n=sentence.length();
        if(sentence.charAt(0)!=sentence.charAt(n-1)){
            return false;
        }
        int i=0;
        while(i<n){
            if(sentence.charAt(i)!=' '){
                i++;
                continue;
            }
            else{
                if(sentence.charAt(i-1)!=sentence.charAt(i+1)){
                    return false;
                }
                else{
                    i++;
                }
            }
        }
        return true;
    }
}