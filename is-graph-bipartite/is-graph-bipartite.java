class Solution {
    public boolean isBipartite(int[][] graph) {
        
        if(graph == null || graph.length ==0){
            return true;
        }
        int size = graph.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<size; i++){
            map.put(i, new ArrayList<>());
        }
        
    
      
        for(int i=0; i<graph.length; i++){
            
            for(int j=0; j< graph[i].length; j++){
                
                  map.get(i).add(graph[i][j]);
            }
        }
        
        int[] visited = new int[size];
        
    
        for(int i=0; i<size; i++){
            
            if(visited[i] == 0 && !dfs(map, i, visited, 1)){
                return false;
            }
            
        }
        
        return true; 
    }
    
    public boolean dfs( Map<Integer, List<Integer>> map, int i, int[] visited, int group){
    
        
        visited[i] = group;
        
        for(Integer path: map.get(i) ){
            if(visited[path]== group){
                return false;
            }
              if(visited[path]==0 && !dfs(map, path, visited, -group)) {
                return false;
            }
        }
        
        return true;
    }
}