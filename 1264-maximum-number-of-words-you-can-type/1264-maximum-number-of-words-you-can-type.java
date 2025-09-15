class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        Set<Character> brokenSet = new HashSet<>();
        
        // Populate the HashSet with broken characters for O(1) lookup
        for (char c : brokenLetters.toCharArray()) {
            brokenSet.add(c);
        }
        
        int count = 0;
        
        // Iterate through each word and check if it can be typed
        for (String word : words) {
            boolean canBeTyped = true;
            for (char c : word.toCharArray()) {
                if (brokenSet.contains(c)) {
                    canBeTyped = false;
                    break; 
                }
            }
            if (canBeTyped) {
                count++;
            }
        }
        return count;
    }
}