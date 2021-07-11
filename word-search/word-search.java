class Solution {
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        
 
        
        for(int i =0; i< m; i++){
            
            for(int j = 0; j<n; j++){
                
                if( exist(board, word, i, j,  0)){
                    return true;
                }
            }
        }
        return false;
        
    }
    
    public boolean exist(char[][] board, String word, int i , int j, int index){
        int m = board.length;
        int n = board[0].length;
        if(index >= word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=m || j>=n || word.charAt(index) != board[i][j]){
            return false;
        }
        
       boolean ret = false;
        
        board[i][j] = '#';
        
        int[] row = {0,1, 0, -1};
        int[] col = {1, 0, -1, 0};
        
        for(int d = 0; d<4; ++d){
            
            ret = exist(board, word, i+ row[d], j+ col[d],  index+1);
            if(ret)
                break;
        }
        
        
         board[i][j] = word.charAt(index);
        return ret;
        
        
        
        
    }
}