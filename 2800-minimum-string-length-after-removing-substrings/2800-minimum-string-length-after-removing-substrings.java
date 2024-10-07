class Solution {
    public int minLength(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if ((s.charAt(i)=='A' && s.charAt(i+1)=='B') || (s.charAt(i)=='C' && s.charAt(i+1)=='D')) {
                String newStr = s.substring(0, i) + s.substring(i+2);
                return minLength(newStr);
            }
        }
        return s.length();
    }
}
