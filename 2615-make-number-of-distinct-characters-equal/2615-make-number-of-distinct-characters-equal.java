class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] letters1 = new int[26];
        int[] letters2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            letters1[c - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            letters2[c - 'a']++;      
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (letters1[j] == 0 || letters2[i] == 0) {
                    continue;
                }
                letters1[j]--;
                letters2[j]++;
                letters1[i]++;
                letters2[i]--;
                int numDistinctCharacters1 = 0;
                int numDistinctCharacters2 = 0;
                for (int k = 0; k < 26; k++) {
                    if (letters1[k] > 0) {
                        numDistinctCharacters1++;
                    }
                    if (letters2[k] > 0) {
                        numDistinctCharacters2++;
                    }
                }
                if (numDistinctCharacters1 == numDistinctCharacters2) {
                    return true;
                }
                letters1[j]++;
                letters2[j]--;
                letters1[i]--;
                letters2[i]++;
            }
        }
        return false;
    }
}