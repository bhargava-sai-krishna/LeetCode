class Solution {
    public int count(String s) {
        int changes = 0;
        boolean zero = true;

        for(char c : s.toCharArray()) {
            if(zero && c != '0' || !zero && c != '1') {
                changes++;
            }
            zero = !zero;
        }

        return changes;
    }
    public int minOperations(String s) {
        int count = count(s);
        return Math.min(count, s.length() - count);
    }
}