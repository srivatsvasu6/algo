class Solution {
    int seq = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer>[] graph = new List[n];
        
        buildgraph(graph, connections);
        int[] low= new int[n];
        int[] disc= new int[n];
        int[] parents= new int[n];
        
        Arrays.fill(low , -1);
        Arrays.fill(parents , -1);
        Arrays.fill(disc , -1);
        
        for(int i = 0; i<n; i++){
            if(disc[i]==-1)
                dfs(graph, i, low, disc, parents, res);
    
        }
        
        return res;
        
         
    }
    
    private void dfs(List<Integer>[] graph, int u, int[] low, int[] disc, int[] parents ,  List<List<Integer>> res){
        if(disc[u] !=-1)
            return;
        
        low[u]= disc[u] = seq++;
        
        
        for(int v: graph[u]){
            
            if(disc[v]==-1){
                parents[v] = u;
                 dfs(graph, v, low, disc, parents, res);
                 low[u] = Math.min(low[u], low[v]);
                
                if(low[v] > disc[u]){
                    res.add(Arrays.asList(u, v));
                }
            }else if (parents[u] != v) {
                 low[u] = Math.min(low[u], disc[v]);
            }
        }
        
        
    }
    
    private void buildgraph( List<Integer>[] graph,  List<List<Integer>> connections) {
        
     for(List<Integer> c:  connections)  {
         
         int u = c.get(0);
         int v  = c.get(1);
         
         if(graph[u]== null){
             graph[u] = new ArrayList<>();
         }
         if(graph[v]== null){
             graph[v] = new ArrayList<>();
         }
         graph[u].add(v);
         graph[v].add(u);
         
     } 
    }
}