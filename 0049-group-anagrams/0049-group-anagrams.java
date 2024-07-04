class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans=new HashMap<>();
        for(String i: strs){
            char[] temp=i.toCharArray();
            Arrays.sort(temp);
            String temp2=new String(temp);
            if(!ans.containsKey(temp2)){
                ans.put(temp2, new ArrayList<>());
            }
            ans.get(temp2).add(i);
        }
        return new ArrayList(ans.values());
    }
}