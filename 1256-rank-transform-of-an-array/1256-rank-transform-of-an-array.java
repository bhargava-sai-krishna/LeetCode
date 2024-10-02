class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sorted = Arrays.stream(arr).distinct().sorted().toArray();
        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i], i + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
