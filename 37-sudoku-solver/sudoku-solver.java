class Solution {
    boolean check=false;
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
        return;
    }
    void helper(char[][] board,int row,int col){
        if(row==9){
            check=true;
            return;

        } 
        if(board[row][col]=='.'){
            for(int k=1;k<=9;k++){
                char ch = (char) (k+'0');
                
                if(isSafe(board,ch,row,col)){
                    board[row][col]=ch;
                    if(col!=8) helper(board,row,col+1);
                    else{
                        helper(board,row+1,0);
                    }
                    if(check==true){
                        return;
                    }
                    board[row][col] = '.';
                }
            }
        }else{
            if(col!=8) helper(board,row,col+1);
            else{
                helper(board,row+1,0);
            }
        }
        return;
    }
    boolean isSafe(char[][]board,char ch,int row,int col){
        for(int i =0;i<9;i++){
            if(board[row][i]==ch){
                return false;
            }
        }
        for(int i =0;i<9;i++){
            if(board[i][col]==ch){
                return false;
            }
        }
        int m = row/3*3;
        int n= col/3*3;
        for(int i=m;i<m+3;i++){
            for(int j=n;j<n+3;j++){
                if(board[i][j]==ch){
                    return false;
                }
            }
        }
        return true;
    }
}