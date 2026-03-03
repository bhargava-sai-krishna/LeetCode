class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        for(int i = 0; i < points.length; i++) {
            heap.offer(new int[] {(int)(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2)), i});
        } 

        int[][] ans = new int[k][2];

        for(int i = 0; i < k; i++) {
            ans[i] = points[heap.poll()[1]];
        }

        return ans;
    }
}