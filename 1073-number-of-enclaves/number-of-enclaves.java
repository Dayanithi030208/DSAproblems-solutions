class Solution {
    public int numEnclaves(int[][] board) {
        int m = board.length;
    int n = board[0].length;
    int[][] visited = new int[m][n];
    for (int j = 0; j < n; j++) {
      if (board[0][j] == 1) {
        dfs(0, j, board, visited);
      }
      if (board[m - 1][j] == 1) {
        dfs(m - 1, j, board, visited);
      }
    }
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 1) {
        dfs(i, 0, board, visited);
      }
      if (board[i][n - 1] == 1) {
        dfs(i, n - 1, board, visited);
      }
    }
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j] == 0 && board[i][j] == 1) {
          count++;
        }
      }
    }
    return count;
    }
    private void dfs(int row, int col, int[][] board, int[][] visited) {
    int m = board.length;
    int n = board[0].length;
    visited[row][col] = 1;
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    for (int i = 0; i < 4; i++) {
      int newrow = row + drow[i];
      int newcol = col + dcol[i];
      if (newrow >= 0
          && newrow < m
          && newcol >= 0
          && newcol < n
          && board[newrow][newcol] == 1
          && visited[newrow][newcol] == 0) {
        dfs(newrow, newcol, board, visited);
      }
    }
  }
}