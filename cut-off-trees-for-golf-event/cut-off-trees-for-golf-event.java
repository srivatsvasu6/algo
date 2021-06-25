class Solution {
       
      int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int cutOffTree(List<List<Integer>> forest) {
      
        if (forest == null || forest.size() == 0) return 0;
        int m = forest.size(), n = forest.get(0).size();
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        
        for(int i=0; i< m; i++){
            for(int j = 0; j<n; j++){
                if(forest.get(i).get(j) > 1)
                    pq.add(new int[]{i, j, forest.get(i).get(j) });
            }
        }
        
        
        int[] start = new int[2];
        int step = 0;
        while(!pq.isEmpty()){
            
            int[] edge = pq.poll();

            int minStep = bfs(forest, start[0], start[1], edge[0], edge[1] );
            
            if(minStep<0)
                return -1;
            
            step += minStep;
            start[0] = edge[0];
            start[1] = edge[1];
            
        }
        
        return step;
    }
    
    private int bfs(List<List<Integer>> forest, int x, int y, int tx, int ty) 
    {
        //A typical BFS approach that we use
        int m = forest.size(), n = forest.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        //Add the current source coordinates to the queue and mark it as visited
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        int dist = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
           
            for (int j = 0; j < size; j++) {
                int[] cur = queue.poll();
                
                 //If we have reached the tree at (tx,ty) through traversal then that means we can return the distance covered from (x,y) to (tx,ty)
                if (cur[0] == tx && cur[1] == ty) 
                    return dist;
                
                //Traverse in all 4 directions and then process it if it meets the conditions
                for (int i = 0; i < 4; i++) 
                {
                    int nx = cur[0]+dirs[i][0];
                    int ny = cur[1]+dirs[i][1];
                    
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && 
                        !visited[nx][ny] && forest.get(nx).get(ny) >= 1)
                    {
                      visited[nx][ny] = true;
                      queue.add(new int[]{nx, ny});
                   }
                }
            }
            dist++;
        }
        return -1;
    }
}