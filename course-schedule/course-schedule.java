class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      
        if(numCourses<1 || prerequisites==null || prerequisites.length==0){
            return true;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<numCourses; i++){
            map.put(i, new ArrayList<Integer>());
        }
        
        for(int[] pre : prerequisites){
            
            map.get(pre[1]).add(pre[0]);
            
        }
        
        int[] visited = new int[numCourses+1];
        
          for(int i=0; i<numCourses; i++){
            if(! dfs(map, i, visited))
           {
                return false;
           }
        }
        return true;
        
    }
    
    public boolean dfs( Map<Integer, List<Integer>> map, int i,  int[] visited ){
        
        if (visited[i] ==-1){
            return false;
        }
        if(visited[i]== 1){
            return true;
        }
        
        visited[i] = -1;
        
     
        
        for(Integer course: map.get(i) ){
            
           if(! dfs(map, course, visited))
           {
                return false;
           }
            
        }
        
        visited[i] = 1;
        return true;
        
    }
    
   
}