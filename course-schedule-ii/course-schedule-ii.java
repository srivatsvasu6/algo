class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        

        
        int[] indeg = new int[numCourses];
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int[] pre: prerequisites){
            
            map.get(pre[1]).add(pre[0]);
            indeg[pre[0]]++;
        }
          Queue<Integer> q = new LinkedList<>();
           
        for(int i=0; i<numCourses; i++){
         if(indeg[i]==0)
             q.add(i);
        }
      
        int[] res = new int[numCourses];
        
       int i=0; 
      while(!q.isEmpty()){
          
          int node = q.poll();
            res[i] = node;
            i++;
          
          for(int adj : map.get(node)){
              indeg[adj]--;
              if(indeg[adj] == 0)
                  q.offer(adj);
              
          }
      }
        
        
        return i!=numCourses ? new int[0]: res ;
      
        
    }
}