class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        
        List<Integer>[] graph = new List[n];
        
        for(int i=0; i<n; i++)
            graph[i] = new ArrayList<Integer>();
        
        
        for(int[] edge: edges){
            
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            
        }
        
        List<Integer> leaves = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            
            if(graph[i].size() <= 1){
                leaves.add(i);
            }
        }
        
        
        int rem = n;
        
        while(rem > 2){
            
            rem -= leaves.size(); 
            List<Integer> newChild = new ArrayList<>();
          
            for(Integer leaf: leaves){
      
             int j  =  graph[leaf].iterator().next();
                
                graph[j].remove(leaf);
                
                if( graph[j].size() == 1){
                    newChild.add(j);
                }
            }
            
            leaves = newChild;
        }
        
        
        return leaves;
        
    }
}