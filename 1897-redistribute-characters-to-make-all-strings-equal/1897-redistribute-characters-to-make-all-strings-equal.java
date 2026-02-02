class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        if(n == 1) {
            return true;
        }

        int totalChars = 0;
        int[] charMap = new int[26];
        for(String str : words) {
            totalChars += str.length();
            for(char c : str.toCharArray()) {
                charMap[c - 'a']++;
            }
        }
        
        if(totalChars % n != 0) {
            return false;
        }

        for(int i : charMap) {
            if(i % n != 0) {
                return false;
            }
        }
        return true;
    }
}