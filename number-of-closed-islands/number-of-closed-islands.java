class Solution {
    public int closedIsland(int[][] grid) {
        int cnt =0;
        for(int i=1; i<grid.length-1; i++){
            
            for(int j=1; j<grid[i].length-1; j++){
                
                if(grid[i][j]== 0 && isClosedIsland(grid, i, j)){
                    cnt++;
                }
            }
        }
        
        return cnt;
        
    }
    
    public boolean isClosedIsland(int[][] grid, int i, int j ){
        
        if(i < 0 || j < 0 || i> grid.length-1 || j> grid[i].length -1){
            return false;
        }
        
        if(grid[i][j] != 0 ){
            return true;
        }
        
         grid[i][j] = -1;
        
         boolean left =   isClosedIsland(grid, i-1, j);
         boolean right =   isClosedIsland(grid, i+1, j);
         boolean up =   isClosedIsland(grid, i, j+1);
         boolean down =   isClosedIsland(grid, i, j-1);
        
        return left && right && up && down;
    }
}