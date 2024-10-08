class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb[] = new StringBuilder[numRows];
        boolean b = true;
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        for (int i = 0, j = 0; i < s.length();) {
            sb[j].append(s.charAt(i++));
            if (j == numRows - 1) {
                b = false;
            }
            if (j == 0) {
                b = true;
            }
            if (b) {
                j++;
            } else {
                j--;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : sb) {
            res.append(stringBuilder);
        }
        return res.toString();
    }
}