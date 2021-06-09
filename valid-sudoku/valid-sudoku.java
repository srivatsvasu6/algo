class Solution {
    public boolean isValidSudoku(char[][] board) {
       
        
        for(int i=0; i<9; i++){
            
            for(int j =0; j<9; j++){
                
                if(board[i][j] !='.' && !validSudoku(board, i, j) ){
                    return false;
                }
            }
        }
        
        return true;
    }
    

        
    public boolean validSudoku(char[][] board, int i, int j){
        char c = board[i][j];
        
        for(int k=0; k<9; k++){
            
            if(k!= j && c == board[i][k]){
                return false;
            }
            
            if(k!= i && c == board[k][j]){
                return false;
            }
            
            int row = 3*(i/3) + k/3; 
            int col = 3*(j/3) + k%3;
            
         
            
            if(row!= i && col !=j && board[row][col]== c){
                return false;
            }
            
            
        }
        return true;
        
        
    }
}