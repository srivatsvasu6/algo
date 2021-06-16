class Solution {
    public int reachableNodes(int[][] edges, int M, int n) {
        
        
        Map<Integer, Map<Integer,Integer>> g = new HashMap<>();
        
        for(int i=0; i<n; i++){
            g.put(i, new HashMap<>());
        }
        
        for(int[] edge : edges){
            
            g.get(edge[0]).put(edge[1], edge[2]);
            g.get(edge[1]).put(edge[0], edge[2]);
        }
        
        Map<Integer,Integer> visited = new HashMap<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1]-a[1]);
        
        pq.offer(new int[]{0, M});
        
        while(!pq.isEmpty()){
            
            int[] node = pq.poll();
            
            int i = node[0];
            int moves = node[1];
            
            if(!visited.containsKey(i)){
                
                visited.put(i, moves);
                
                for( int j : g.get(i).keySet()){
                    
                    int remMov = moves - g.get(i).get(j) -1;
                    
                    if(!visited.containsKey(j) && remMov >=0)
                        pq.offer(new int[]{j, remMov});
                }
            }
            
            
        }
        
        int res = visited.size();
        
        for(int[] edge: edges){
           int a = visited.getOrDefault(edge[0],0);
           int b = visited.getOrDefault(edge[1],0);
           res += Math.min(a+b, edge[2]);
        }
        
        return res;
        
    }
}