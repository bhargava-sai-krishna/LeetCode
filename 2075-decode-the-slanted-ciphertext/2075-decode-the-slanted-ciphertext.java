class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(encodedText.isEmpty()) {
            return encodedText;
        }
        int len = encodedText.length();
        int cols = len / rows;
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < cols; i++) {
            int r = 0, c = i;

            while(r < rows && c < cols) {
                ans.append(encodedText.charAt(r * cols + c));
                r++;
                c++;
            }
        }

        return ans.toString().stripTrailing();
    }
}