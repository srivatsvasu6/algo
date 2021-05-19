class Solution {
    public int totalNQueens(int n) {
        
        char[][] grid = new char[n][n];
        
        for(int i=0; i<n; i++)
            Arrays.fill(grid[i], '.');
        
        int[] left = new int[n];
        int[] upperDia = new int[2*n-1];
        int[] lowerDia = new int[2*n-1];
        List<Integer> res = new ArrayList<>();
        backtrack(grid, res,left, upperDia, lowerDia, 0);
        return res.size();
    }
    
    public void   backtrack(char[][] grid,  List<Integer> res, int[] left,int[] upperDia, int[] lowerDia, int col){
        if(col == grid.length){
            res.add(1);
            return;
        }
        for(int row = 0; row<grid.length; row++ ){
            
             if(left[row]==0 && lowerDia[row + col] ==0 && upperDia[grid.length -1 + col - row]==0 ){
               left[row]=1;
               lowerDia[row + col] =1;
               upperDia[grid.length -1 + col - row]=1;
               grid[row][col] ='Q';
               backtrack(grid, res,left, upperDia, lowerDia, col+1);
               left[row]=0;
               lowerDia[row + col] =0;
               upperDia[grid.length -1 + col - row]=0;
               grid[row][col] ='.';
          }
        }
    }
}