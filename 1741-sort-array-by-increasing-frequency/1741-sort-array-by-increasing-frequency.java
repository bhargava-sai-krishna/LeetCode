class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        numsList.sort((a, b) -> {
            int freqCompare = frequencyMap.get(a) - frequencyMap.get(b);
            if (freqCompare != 0) {
                return freqCompare;
            } else {
                return b - a;
            }
        });
        int[] result = new int[nums.length];
        for (int i = 0; i < numsList.size(); i++) {
            result[i] = numsList.get(i);
        }
        return result;
    }
}
