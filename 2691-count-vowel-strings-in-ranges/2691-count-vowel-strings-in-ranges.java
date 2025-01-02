class Solution {
    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            char first = words[i].charAt(0), last = words[i].charAt(words[i].length() - 1);
            prefix[i + 1] = prefix[i] + (isVowel(first) && isVowel(last) ? 1 : 0);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }
        return ans;
    }
}