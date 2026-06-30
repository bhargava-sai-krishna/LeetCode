class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int left = 0, right = 0;
        int total = 0;
        int[] freq = new int[3];

        while(right < len) {
            freq[s.charAt(right) - 'a']++;

            while(hasAllChars(freq)) {
                total += len - right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return total;
    }

    private boolean hasAllChars(int[] freq) {
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
}