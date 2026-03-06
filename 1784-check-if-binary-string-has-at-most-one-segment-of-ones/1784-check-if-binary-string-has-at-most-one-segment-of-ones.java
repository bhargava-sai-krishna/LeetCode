class Solution {
    public boolean checkOnesSegment(String s) {
        boolean encountered = false;

        for(int i = 0; i < s.length(); i++) {
            if(encountered && s.charAt(i) == '1') {
                return false;
            }

            while(i < s.length() && s.charAt(i) == '1') {
                i++;
                encountered = true;
            }
        }

        return true;
    }
}