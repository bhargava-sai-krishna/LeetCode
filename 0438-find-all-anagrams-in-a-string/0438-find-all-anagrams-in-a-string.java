class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        if (n < m) {
            return new ArrayList<>();
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sCount[s.charAt(i) - 'a']++;
            if (i >= m) {
                sCount[s.charAt(i - m) - 'a']--;
            }
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i - m + 1);
            }
        }
        return ans;
    }
}
