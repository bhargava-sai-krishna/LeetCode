class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean found = dfs(board, word, i, j, 0, visited);
                    if (found) return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        
        int m = board.length;
        int n = board[0].length;
        
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || board[i][j] != word.charAt(index))
            return false;
        
        visited[i][j] = true;
        
        if (dfs(board, word, i + 1, j, index + 1, visited) ||
            dfs(board, word, i - 1, j, index + 1, visited) ||
            dfs(board, word, i, j + 1, index + 1, visited) ||
            dfs(board, word, i, j - 1, index + 1, visited))
            return true;
        
        visited[i][j] = false;
        
        return false;
    }
}
