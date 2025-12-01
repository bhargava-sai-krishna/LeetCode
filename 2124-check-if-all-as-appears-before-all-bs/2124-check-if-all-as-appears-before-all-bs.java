class Solution {
    public boolean checkString(String s) {
        boolean start=false;
        for(char c:s.toCharArray()){
            if(c=='a' && start){
                return false;
            }
            if(c=='b'){
                start=true;
            }
        }
        return true;
    }
}