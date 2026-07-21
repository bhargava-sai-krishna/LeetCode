class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        k %= total;

        List<List<Integer>> ans = new ArrayList<>(m);

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(n, 0));
            ans.add(row);
        }

        for (int idx = 0; idx < total; idx++) {
            int newIdx = (idx + k) % total;

            ans.get(newIdx / n)
               .set(newIdx % n, grid[idx / n][idx % n]);
        }

        return ans;
    }
}