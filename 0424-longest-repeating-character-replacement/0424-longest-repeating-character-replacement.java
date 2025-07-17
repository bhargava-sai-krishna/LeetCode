class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map=new HashMap<>();
        int i=0, maxFreq=0, maxLen=0;
        for(int j=0;j<s.length();j++){
            char curr=s.charAt(j);
            map.put(curr, map.getOrDefault(curr, 0)+1);
            maxFreq=Math.max(maxFreq, map.get(curr));
            while((j-i+1)-maxFreq>k){
                char l=s.charAt(i);
                map.put(l, map.get(l)-1);
                i++;
            }
            maxLen=Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}