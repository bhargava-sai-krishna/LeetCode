class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int max=0;
        int n=s.length();
        Set<Character> ch=new HashSet<>();
        while(j<n)
        {
            if(!ch.contains(s.charAt(j)))
            {
                ch.add(s.charAt(j));
                j++;
                max=Math.max(ch.size(),max);
            }
            else
            {
                ch.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}