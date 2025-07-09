class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations=new ArrayList<>();
        List<Integer> combination=new ArrayList<>();
        backtrack(1, combination, combinations, n, k);
        return combinations;
    }
    public void backtrack(int start, List<Integer> combination, List<List<Integer>> combinations, int n, int k){
        if(combination.size()==k){
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for(int i=start;i<=n;i++){
            combination.add(i);
            backtrack(i+1, combination, combinations, n, k);
            combination.remove(combination.size()-1);
        }
    }
}