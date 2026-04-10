class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;

        int t = 0;
        while(t <= m) {
            int mid = (t + m) / 2;
            if(matrix[mid][0] < target && matrix[mid][matrix[mid].length - 1] >= target) {
                break;
            } else if(matrix[mid][0] > target) {
                m = mid - 1;
            } else {
                t = mid + 1;
            }
        }

        int row = (t + m) / 2;
        int l = 0;
        while(l <= n) {
            int mid = (l + n) / 2;
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] > target) {
                n = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}