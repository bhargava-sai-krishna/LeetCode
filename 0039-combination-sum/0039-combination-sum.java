class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates, target, new ArrayList<>(), new ArrayList<>(), 0);
    }
    
    public List<List<Integer>> helper(int[] candidates, int target, List<Integer> temp, List<List<Integer>> out, int index) {
        if (target == 0) {
            out.add(new ArrayList<>(temp));
            return out;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break;
            temp.add(candidates[i]);
            helper(candidates, target - candidates[i], temp, out, i);
            temp.remove(temp.size() - 1);
        }
        return out;
    }
}
