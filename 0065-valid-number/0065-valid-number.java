class Solution {
    public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();
        if (s.length() == 0) return false;

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        boolean digitsAfterExp = true; // becomes false when we see 'e' and must be set true by digits after it

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                seenDigit = true;
                if (seenExp) digitsAfterExp = true;
            } else if (c == '+' || c == '-') {
                // sign is allowed only at start or immediately after 'e'/'E'
                if (i != 0) {
                    char prev = s.charAt(i - 1);
                    if (prev != 'e' && prev != 'E') return false;
                }
            } else if (c == '.') {
                // dot not allowed after exponent and only one dot allowed
                if (seenDot || seenExp) return false;
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // exponent allowed only once and must follow at least one digit
                if (seenExp || !seenDigit) return false;
                seenExp = true;
                digitsAfterExp = false; // require a digit after e
            } else {
                // any other character is invalid
                return false;
            }
        }

        // must have seen a digit and, if exponent present, digits after it
        return seenDigit && (!seenExp || digitsAfterExp);
    }
}
