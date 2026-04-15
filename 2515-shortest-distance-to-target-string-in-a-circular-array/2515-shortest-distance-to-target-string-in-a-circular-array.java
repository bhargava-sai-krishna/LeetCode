class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = n;

        for(int i = 0; i < n; i++) {
            if(words[i].equals(target)) {
                int gap = Math.abs(startIndex - i);
                ans = Math.min(ans, Math.min(gap, n - gap));
            }
        }

        return (ans == n) ? -1 : ans;
    }
}