class Solution {
    public int numIslands(char[][] grid) {
        
     int r = grid.length;
     int c = grid[0].length;
     boolean[][] visited = new boolean[r][c];
       int count =0; 
        
        for(int i=0; i<r; i++){
            
            for(int j=0; j<c; j++){
                
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    dfs(visited, grid, i, j);
                    
                }
            }
        }
        
        return count;
        
        
    }
    
    public void dfs(boolean[][] visited, char[][] grid, int i, int j){
        
        int r = grid.length;
        int c = grid[0].length;
        
        if( i<0 || j<0 || i>=r || j>=c || visited[i][j] || grid[i][j]=='0' ){
            return;
        }
        
        visited[i][j] = true;
        
        dfs(visited, grid, i-1, j);
        dfs(visited, grid, i, j-1);
        dfs(visited, grid, i+1, j);
        dfs(visited, grid, i, j+1);
        
        
        
        
    }
}