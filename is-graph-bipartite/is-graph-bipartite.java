class Solution {
    public boolean isBipartite(int[][] graph) {
        
        if(graph==null || graph.length==0){
            return true;
        }
        
        int[] visited = new int[ graph.length ];
        
        for(int i=0; i< graph.length; i++){
            if(visited[i]==0  && !dfs(graph, visited, i,  1  )){
                 return false;
            }
            
        }
        
        return true;
    }
    
    public boolean dfs(int[][]graph, int[] visited , int i, int grp){
        
        visited[i] = grp;
        
        
        for(int node : graph[i]){
            
            if(visited[node] == grp){
                return false;
            }
            
            if(visited[node]==0 && !dfs(graph, visited, node, -grp)) {
                return false;
            }
        }
        
        return true;
        
    }
}