class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        if(grid[0][0] == 1)
            return -1;
        int m = grid.length , n = grid[0].length, count =0;
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = 1;
        queue.offer(new int[]{0,0});
        
        while(!queue.isEmpty()){
            
         int[] node =  queue.poll();
            count = grid[node[0]][node[1]];
        if(node[0]== m-1 && node[1] == n-1){
            return count;
        }
       
            for(int[] adj : getNeighbor(node, grid) ){
                
                 queue.add(adj);
                 grid[adj[0]][adj[1]] = 1 + count;
            }
        }
        
        return -1;

    }
    
    int[] dr = {1,1,1,0,-1,-1,-1,0};
    int[] dc = {-1,0,1,1,1,0,-1,-1};
    
    
    
    public List<int[]> getNeighbor(int[] node, int[][] grid){
        List<int[]>  adj = new ArrayList<>();
        for(int i = 0; i<8 ; i++){
            
          int row =    node[0] + dr[i];
          int col =   node[1] + dc[i];
            
          if(row < 0 || col <0 || row >= grid.length || col >= grid[0].length|| grid[row][col]!=0){
              continue;
          }
          adj.add(new int[]{row, col});  
            
            
        }
        return adj;
        
    }
}