class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
       int m = grid.length ;
       int n = grid[0].length ;
       for ( int i = 0 ; i < m ; i++){
        for ( int j = 0 ; j < n ; j++){
            if(grid[i][j] == '1'){
                dfs(grid , i , j);
                count++;
            }
        }
       }
       return count;
    }
    public void dfs(char[][] grid,int i , int j){
        int m = grid.length ;
        int n = grid[0].length;
        if(i == m || j == n || i < 0 || j < 0 || grid[i][j] == '0') return ;
        grid[i][j] = '0';
        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};
        for(int k = 0 ; k < 4 ; k++){
            dfs(grid,i + dx[k] , j + dy[k]);
        }
    }
}