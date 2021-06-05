class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        int cnt =0;
        int[] res = new int[numCourses];
        int[] indeg = new int[numCourses];
        
        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int[] pre: prerequisites){
            map.get(pre[1]).add(pre[0]);
            indeg[pre[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++){
            
            if(indeg[i]==0)
                queue.offer(i);
        }
        
        while(! queue.isEmpty()){
            int node = queue.poll();
            res[cnt++] = node;
            
            for(int adj: map.get(node)){
                
                indeg[adj]--;
                if(indeg[adj]==0)
                    queue.offer(adj);
            }
            
        }
        
        if(cnt != numCourses){
            return new int[0];
        }
        
        return res;
    }
}