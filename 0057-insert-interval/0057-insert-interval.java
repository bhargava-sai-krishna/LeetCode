class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        return Stream.concat(Arrays.stream(intervals), Stream.of(newInterval))
                .sorted(Comparator.comparingInt(a -> a[0]))
                .collect(ArrayList<int[]>::new, (list, curr) -> {
                    if (list.isEmpty() || list.get(list.size() - 1)[1] < curr[0]) {
                        list.add(curr);
                    } else {
                        list.get(list.size() - 1)[1] =
                                Math.max(list.get(list.size() - 1)[1], curr[1]);
                    }
                }, (l1, l2) -> {})
                .toArray(new int[0][]);
    }
}