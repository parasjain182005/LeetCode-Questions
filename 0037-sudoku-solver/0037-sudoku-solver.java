class Solution {
    public boolean isSafe(char[][] board, int row, int col, char target){
        for(int i=0; i<board.length; i++){
            if(board[i][col]==target){
                return false;
            }
        }
        for(int i=0; i<board.length; i++){
            if(board[row][i]==target){
                return false;
            }
        }
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(board[i][j]==target){
                 return false;
                }
            }
        }
        return true;
    }
    
    public boolean sudoku(char[][] board, int row, int col){
        if(row==9 && col==0){
            return true;
        }
        int nextRow = row, nextCol = col+1;
        if(nextCol==9){
            nextRow = row+1;
            nextCol = 0;
        }
        if(board[row][col]!='.'){
            return sudoku(board, nextRow, nextCol);
        }

        for(int i=1; i<=9; i++){
            char ch = (char) (i + '0');
            if(isSafe(board,row,col,ch)){
                board[row][col] = ch;

                if(sudoku(board,nextRow,nextCol)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        boolean x = sudoku(board,0,0);
    }
}