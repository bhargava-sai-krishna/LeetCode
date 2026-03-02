class Solution {
    private static void swap(int[] zeros, int i, int j) {
        int temp = zeros[i];
        zeros[i] = zeros[j];
        zeros[j] = temp;
    }

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeros = new int[n];

        for(int i = 0; i < n; i++) {
            int count = 0 ;
            for(int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
                count++;
            }
            zeros[i] = count;
        }

        int swaps = 0;

        for(int i = 0; i < n; i++) {
            int needed = n - i - 1;

            int j = i;
            while(j < n && zeros[j] < needed) {
                j++;
            }

            if(j == n) {
                return -1;
            }

            while(j > i) {
                swap(zeros, j, j - 1);
                j--;
                swaps++;
            }
        }

        return swaps;
    }
}