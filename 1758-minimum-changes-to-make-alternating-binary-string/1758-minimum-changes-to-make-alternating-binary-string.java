class Solution {
    public int count(String s, char number) {
        int changes = 0;
        boolean zero = (number == '0') ? true : false;

        for(char c : s.toCharArray()) {
            if(zero && c != '0' || !zero && c != '1') {
                changes++;
            }
            zero = !zero;
        }

        return changes;
    }
    public int minOperations(String s) {
        int count = count(s, '0');
        return Math.min(count, s.length() - count);
    }
}