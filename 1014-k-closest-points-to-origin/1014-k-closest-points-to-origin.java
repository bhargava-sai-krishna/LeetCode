class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> dis = new ArrayList<>();
        int[][] ans = new int[k][2];
        for (int i = 0; i < points.length; i++) {
            int d=points[i][0]*points[i][0]+points[i][1]*points[i][1];
            dis.add(new int[]{d, points[i][0], points[i][1]});
        }
        dis.sort((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < k; i++) {
            ans[i][0] = dis.get(i)[1];
            ans[i][1] = dis.get(i)[2];
        }

        return ans;
    }
}
