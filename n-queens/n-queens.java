class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        
      
        char[][] grid = new char[n][n];
        
        for(int i=0; i<n; i++)
        Arrays.fill(grid[i], '.');
        
       int[] upperDia = new int[2*n-1];
        
       int[] lowerDia = new int[2*n-1];
        
       int[] left = new int[n];
        
        backtrack(grid, upperDia, lowerDia, left, res, 0);
        
        return res;
    }
     private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    
    public void  backtrack(char[][] grid, int[] upperDia, int[] lowerDia, int[] left,  List<List<String>> res, int col){
        
       if(col == grid.length){
           res.add(construct(grid));
           return;
       } 
       
       for(int row = 0; row< grid.length; row++){
           
           if(left[row]==0 && lowerDia[row + col] ==0 && upperDia[grid.length -1 + col - row]==0 ){
               left[row]=1;
               lowerDia[row + col] =1;
               upperDia[grid.length -1 + col - row]=1;
               grid[row][col] ='Q';
               backtrack(grid, upperDia, lowerDia, left, res, col+1);
               left[row]=0;
               lowerDia[row + col] =0;
               upperDia[grid.length -1 + col - row]=0;
               grid[row][col] ='.';
          }
       }
    }
}