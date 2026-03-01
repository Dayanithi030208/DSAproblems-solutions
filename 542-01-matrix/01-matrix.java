class Pair {
    int row;
    int col;
    int distance;

    Pair(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new Pair(i, j, 0));
                    result[i][j] = 0;
                }
            }
        }
        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };
        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int distance = queue.peek().distance;
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int newrow = row + drow[i];
                int newcol = col + dcol[i];
                if (newrow >= 0 && newrow < m && newcol >= 0 && newcol < n && result[newrow][newcol] == -1) {
                    result[newrow][newcol] = distance + 1;
                    queue.offer(new Pair(newrow, newcol, distance + 1));
                }
            }
        }
        return result;
    }
}