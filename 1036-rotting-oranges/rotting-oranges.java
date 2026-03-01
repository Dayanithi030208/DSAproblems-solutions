class Pair {
    int row;
    int col;
    int timetaken;

    Pair(int row, int col, int timetaken) {
        this.row = row;
        this.col = col;
        this.timetaken = timetaken;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }
                if (grid[i][j] == 1)
                    freshOranges++;
            }
        }
        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };
        int maxTimeTaken = 0;
        int rottenOranges = 0;
        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int timetaken = queue.peek().timetaken;
            maxTimeTaken = Math.max(maxTimeTaken, timetaken);
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int newrow = row + drow[i];
                int newcol = col + dcol[i];
                if (newrow >= 0 && newrow < m && newcol >= 0 && newcol < n && visited[newrow][newcol] == 0
                        && grid[newrow][newcol] == 1) {
                    visited[newrow][newcol] = 2;
                    queue.offer(new Pair(newrow, newcol, timetaken + 1));
                    rottenOranges++;
                }
            }
        }
        if (rottenOranges != freshOranges)
            return -1;
        return maxTimeTaken;
    }
}