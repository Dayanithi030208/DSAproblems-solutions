class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];

        if (originalColor == newColor)
            return image;

        dfs(image, sr, sc, originalColor, newColor);

        return image;
    }

    public void dfs(int[][] image, int i, int j, int originalColor, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if (i == m || j == n || i < 0 || j < 0 || image[i][j] != originalColor)
            return;
        image[i][j] = newColor;
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int k = 0; k < 4; k++) {
            dfs(image, i + dx[k], j + dy[k], originalColor, newColor);
        }
    }
}