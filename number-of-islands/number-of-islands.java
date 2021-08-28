class Solution {
    public int numIslands(char[][] grid) {
        
        
        int row = grid.length, col = grid[0].length;
        int count = 0;
        for(int i = 0; i<row; i++){
            
            for(int j = 0; j<col; j++){
                
                if(grid[i][j]=='1'){
                    dfsHelper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfsHelper(char[][] grid, int i , int j){
        
        int row = grid.length, col = grid[0].length;
        
        if(i<0 || i>= row || j<0 || j>= col || grid[i][j]=='0'){
            return;
        }
        
           grid[i][j] = '0';
           dfsHelper(grid, i+1, j);
           dfsHelper(grid, i, j+1);
           dfsHelper(grid, i-1, j);
           dfsHelper(grid, i, j-1);
        
    }
}