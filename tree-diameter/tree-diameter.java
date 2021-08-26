class Solution {
    int diameter = 0;
    public int treeDiameter(int[][] edges) {
           
        int len = edges.length;
        
        Map<Integer, List<Integer>> adjMatrix = new HashMap<>();
        
        for(int[] edge: edges){
            
            adjMatrix.putIfAbsent(edge[0], new ArrayList<>());
            adjMatrix.putIfAbsent(edge[1], new ArrayList<>());
            adjMatrix.get(edge[0]).add(edge[1]);
            adjMatrix.get(edge[1]).add(edge[0]);
            
            
        }
        
        boolean[] visited = new boolean[adjMatrix.size()];
        
        helper(adjMatrix, 0, visited);
        
        return diameter;
    }
    
     public int helper( Map<Integer, List<Integer>> adjMatrix , int node, boolean[] visited)     {
      int firstMax =0, secondMax = 0, height=0;
    
        if(visited[node] || !adjMatrix.containsKey(node))
        {
            return 0;
        }
        visited[node] = true;
     
            
            
        for(int adj : adjMatrix.get(node)){
            if(!visited[adj])
       height = 1+ helper(adjMatrix, adj , visited );
        if(height > firstMax){
            secondMax = firstMax;
            firstMax = height;
        }else if(height > secondMax){
            secondMax = height;
        }
    }
            
        diameter = Math.max(diameter, firstMax+secondMax);
        
    
        return firstMax;
        
    }
    
}