class Solution {
    boolean[] ch;

    public boolean wordBreak(String s, List<String> wordDict) {
        ch = new boolean[s.length() + 1];
        ch[s.length()] = true; 
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (wordDict.contains(s.substring(i, j)) && ch[j]) {
                    ch[i] = true;
                    break;
                }
            }
        }
        return ch[0];
    }
}
