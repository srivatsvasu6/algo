class Solution {
    public void solve(char[][] grid) {
       if(grid ==null|| grid.length ==0)
            return;
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0 || i==m-1 || j==n-1 && grid[i][j]=='O'){
                        dfs( grid,i,j);
                    }
                }
        }
        
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
           
                if(grid[i][j]=='O'){
                    grid[i][j]='X';
                }
                
                if(grid[i][j]=='-'){
                   grid[i][j]='O'; 
            
                }
             }
      
        }
    }
    
  public void dfs( char[][] grid, int i, int j){

    if(i < 0 || j< 0 || i> grid.length-1 || j>grid[0].length-1 || grid[i][j] !='O' ) {
        return;
    }
      
   

     
      grid[i][j] = '-';
      
      
      dfs( grid, i+1, j);
      dfs(grid, i, j+1);
      dfs(grid, i-1, j);
      dfs(grid, i, j-1);

     
        
     


}
}