class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String ds = s + s;
        return kmpSearch(ds, goal);
    }
    public boolean kmpSearch(String txt, String pattern) {
        int[] lps = compute(pattern);
        int ti = 0, pi = 0;
        int tl = txt.length(), pl = pattern.length();

        while (ti < tl) {
            if (txt.charAt(ti) == pattern.charAt(pi)) {
                ti++;
                pi++;
                if (pi == pl) {
                    return true;
                }
            } 
            else if (pi > 0) {
                pi = lps[pi - 1];
            } 
            else {
                ti++;
            }
        }
        return false;
    }
    public int[] compute(String pattern) {
        int pl = pattern.length();
        int[] lps = new int[pl];
        int len = 0, idx = 1;
        while (idx < pl) {
            if (pattern.charAt(idx) == pattern.charAt(len)) {
                len++;
                lps[idx++] = len;
            } 
            else if (len > 0) {
                len = lps[len - 1];
            } 
            else {
                lps[idx++] = 0;
            }
        }
        return lps;
    }
}
