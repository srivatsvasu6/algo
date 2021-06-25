class Solution {
       
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

            int minStep = getMin(forest, start, edge, m, n );
            
            if(minStep<0)
                return -1;
            
            step += minStep;
            start[0] = edge[0];
            start[1] = edge[1];
            
        }
        
        return step;
        
    }
    
    private int getMin(List<List<Integer>> forest, int[] start,int[] edge,int m,int n ){
        int step = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] dirs =  {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            
            for(int i= queue.size(); i>0; i--){
                
                int[] node = queue.poll();
                
                if(node[0]==edge[0] && node[1]==edge[1])
                    return step;
                
                for(int[] dir: dirs){
                    int dx = dir[0] + node[0];
                    int dy = dir[1] + node[1];
                    
                    if(dx< 0|| dy<0 ||dx>=m || dy>=n || forest.get(dx).get(dy)==0 || visited[dx][dy])
                        continue;
                    
                    visited[dx][dy]= true;
                    queue.offer(new int[]{dx,dy });
                }
            }
            step++;
        }
        
        return -1;
        
    }
}