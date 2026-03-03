class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return Double.compare(
                Math.pow(a[0], 2) + Math.pow(a[1], 2), 
                Math.pow(b[0], 2) + Math.pow(b[1], 2)
            );
        });

        for(int[] point : points) {
            heap.offer(point);
        }

        int[][] ans = new int[k][2];

        for(int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}