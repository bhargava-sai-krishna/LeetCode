class Solution {
    public boolean isPalindrome(String s) {
        int f = 0;
        int l = s.length() - 1;
        while (l > f) {
            char fc = s.charAt(f);
            char lc = s.charAt(l);
            if (!Character.isLetterOrDigit(fc)) {
                f++;
            } 
            else if (!Character.isLetterOrDigit(lc)) {
                l--;
            } 
            else {
                if (Character.toLowerCase(fc) != Character.toLowerCase(lc)) {
                    return false;
                }
                f++;
                l--;
            }
        }
        return true;
    }
}
