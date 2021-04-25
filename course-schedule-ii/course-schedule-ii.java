class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         Map<Integer, List<Integer>> map = new HashMap<>();
        
        int[] indegree = new int[numCourses];
       
        int[] topSort = new int[numCourses];
        
        
        for(int i=0; i<prerequisites.length; i++){
            
            int src= prerequisites[i][1];
            int dest= prerequisites[i][0];
             List<Integer> lst =  map.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            map.put(src, lst);
            indegree[dest] ++;
              
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        int i=0;
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            topSort[i++] = node;
            
            if(map.containsKey(node)){
                
                for(Integer course: map.get(node)){
                    
                    indegree[course]--;
                    
                    if(indegree[course] ==0){
                        q.offer(course);
                    }
                    
                }
            }
            
        }
    
      
      
        return (i== numCourses) ? topSort : new int[0];
    }
    
  
}