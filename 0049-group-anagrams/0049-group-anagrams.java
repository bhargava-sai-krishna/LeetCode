class Solution {
    private String generateKey(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            String key = generateKey(s);

            if(map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                map.put(key, new ArrayList<>(Arrays.asList(s)));
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}