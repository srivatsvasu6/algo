class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc,  int newColor) {
        int m = grid.length;
        int n = grid[0].length;
     
        int c = grid[sr][sc];
        if(c !=newColor)
        dfs(grid,  sr, sc, m, n, c, newColor);
                   
        
        return grid;
    }
    
    public void dfs(int[][] grid,  int i , int j, int m, int n, int c, int nc){
        
        if(i<0 || j<0 || i>=m ||j>=n ||  grid[i][j] !=c ){
            return;
        }
       
        
         grid[i][j]=nc;
        
         dfs(grid, i+1, j, m, n, c, nc);
         dfs(grid, i, j+1, m, n, c, nc);
         dfs(grid,i-1, j, m, n, c, nc);
         dfs(grid,i, j-1, m, n, c, nc);
    }
}