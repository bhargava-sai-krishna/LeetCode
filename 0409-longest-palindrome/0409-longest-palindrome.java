class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];

        for(char c : s.toCharArray()) {
            freq[c]++;
        }

        int count = 0;
        boolean hasOdd = false;

        for(int i : freq) {
            if(i % 2 == 0) {
                count += i;
            } else {
                count = count + i - 1;
                hasOdd = true;
            }
        }

        return hasOdd ? count + 1 : count;
    }
}