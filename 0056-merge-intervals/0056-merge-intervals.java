class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt((int[] a) -> a[0])
              .thenComparingInt(a -> a[1])
        );

        for(int[] interval : intervals) {
            pq.offer(interval);
        }

        List<int[]> ans = new ArrayList<>();

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            if(ans.isEmpty()) {
                ans.add(curr);
                continue;
            }

            int[] prev = ans.get(ans.size() - 1);

            if(curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else{
                ans.add(curr);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}