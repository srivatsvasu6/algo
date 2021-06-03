class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         Map<Integer, List<Integer>> map = new HashMap<>();
        
         for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
         }
        
        
        for(int[] pre: prerequisites){
         
            map.get(pre[0]).add(pre[1]);
            
           
        }
        
        
        List<Integer> stack = new ArrayList<>();
        int[] visited = new int[numCourses];
      
        
        for(int i=0; i<numCourses; i++){
            if(visited[i]==0 && !dfs(i, map, stack, visited)){
                return new int[0]; 
            }

        }
        
        int[] res = new int[stack.size()];
        int i = numCourses;
        for(int n: stack)
            res[--i] = n;
        
        return res;
        
        
    }
    
    public boolean dfs( int node,  Map<Integer, List<Integer>> map ,  List<Integer> stack,    int[] visited){
       if(visited[node]==1)
           return true;
       else if(visited[node]==-1)
           return false;
        visited[node] = -1;
        
        if(!map.containsKey(node))
            return true;
        
        for(Integer adj : map.get(node)){
  
                if(!dfs(adj, map, stack, visited)){
                    return false;
                }
            
        }
        visited[node] = 1;
        
         stack.add(0, node);
          
        
       return true;
        
    }
    
  
}