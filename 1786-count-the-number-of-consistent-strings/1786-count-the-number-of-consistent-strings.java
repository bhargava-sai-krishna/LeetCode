class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> all=new HashSet<>();
        for(char c:allowed.toCharArray()){
            all.add(c);
        }
        int ans=0;
        for(String s:words){
            boolean flag=true;
            for(char c:s.toCharArray()){
                if(!all.contains(c)){
                    flag=false;
                    continue;
                }
            }
            if(flag){
                ans++;
            }
        }
        return ans;
    }
}