class Solution {
    public int numEnclaves(int[][] grid) {
        
        if(grid ==null|| grid.length ==0)
            return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i=0; i< rows; i++){
            for(int j=0; j<cols; j++){
                
                if(i==0 || j==0 || i==rows-1 || j==cols -1){
                    dfs(grid, i, j);
                }
            }
        }
        int res = 0;
        
        for(int i=0; i< rows; i++){
            for(int j=0; j<cols; j++){
                
                if(grid[i][j]==1){
                    res++;
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int[][] grid, int i, int j){
        
        if(i<0 || j<0 || i>= grid.length || j>=grid[0].length){
            return;
        }
        
        if(grid[i][j] != 1){
            return;
        }
        
         grid[i][j] = -1;
        
          dfs(grid, i+1, j);
          dfs(grid, i, j+1);
          dfs(grid, i-1, j);
          dfs(grid, i, j-1);
        
        
    }
}