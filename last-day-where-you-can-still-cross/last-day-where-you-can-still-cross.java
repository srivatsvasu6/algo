class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
     
        int start= 0,end = cells.length-1, mid = 0;
       
        
        while(start <= end){
        
             mid  = start + (end-start)/2;
            
            
            if(canPass(mid, row, col, cells)){
                start = mid +1;
                
            }else{
                end = mid -1;
            }
            
        }
        
        
    
        return end;
        
    }

    public boolean canPass(int day , int row, int col, int[][] cells){
    int[][] grid = new int[row][col];
        
        
        for(int i = 0; i< day; i++){
            
            int[] cell = cells[i];
            grid[cell[0]-1][cell[1]-1]= 1;
            
        }
        
        for(int i = 0; i< grid[0].length; i++){
            
            if(grid[0][i] ==0 && dfs(grid, 0, i, new Boolean[ grid.length][ grid[0].length])){
                return true;
            }
        }
        return false;
    }
    
    
    public boolean dfs(int[][] grid, int i, int j,  Boolean[][] vis){
        int m = grid.length;
        int n = grid[0].length;
        if(i >= m || j >= n || i<0 || j< 0 || grid[i][j] != 0 ){
            return false;
        }
        
        if(i == m -1){
            return true;
        }

        if(vis[i][j] !=null){
            return vis[i][j];
        }
        
        grid[i][j]  = 2;
        boolean res = dfs(grid, i+1, j, vis) || dfs(grid, i, j+1, vis)|| dfs(grid, i-1, j, vis) || dfs(grid, i, j-1, vis);
        grid[i][j]  = 0;
        vis[i][j] = res;
        
        return res;
        
        
    }
}