class Solution {
    public void backtrack(String combi,String digits,String[] map,List<String> l){
        if(digits.isEmpty()){
            l.add(combi);
        }
        else{
            String letters=map[digits.charAt(0)-'2'];
            for(char letter:letters.toCharArray()){
                backtrack(combi+letter,digits.substring(1),map,l);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())return Collections.emptyList();
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> l=new ArrayList<>();
        backtrack("",digits,map,l);
        return l;
    }
}