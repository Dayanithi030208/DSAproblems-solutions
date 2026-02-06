class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(isWordPresent(board,word,i,j,0)) return true;
                }
            }
        }
        return false;
    }
    private boolean isWordPresent(char[][] board, String word,int row ,int col, int wb){
        if (wb == word.length()) return true;
        if(row < 0 || col < 0 || row == board.length || col == board[0].length || board[row][col] != word.charAt(wb)) return false;
        char ch = board[row][col];
        board[row][col] = '#';
        boolean op1 = isWordPresent(board,word,row,col+1,wb+1);
        boolean op2 = isWordPresent(board,word,row+1,col,wb+1);
        boolean op3 = isWordPresent(board,word,row,col-1,wb+1);
        boolean op4 = isWordPresent(board,word,row-1,col,wb+1);
        board[row][col] = ch;
        return op1 || op2 || op3 || op4;
    }
}