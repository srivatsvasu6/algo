class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        
       List<Integer> critical = new ArrayList<>();
       List<Integer> pseudo = new ArrayList<>();
     
      
        Map<int[], Integer> map = new HashMap<>();
        int i=0;
        for(int[] edge : edges){
            
            map.put(edge, i++);
            
        }
        
        Arrays.sort(edges, (a,b) -> Integer.compare(a[2], b[2]));
        int minCost = findCost(edges, n, null, null);
        
        
        for(int[] edge : edges){
            
            int index = map.get(edge);
            int costWithout = findCost(edges, n, null, edge);
            
            if(costWithout  > minCost){
                critical.add(index);
            }else{
            int costWith = findCost(edges, n, edge, null); 
                if(costWith == minCost){
                    pseudo.add(index);
                }
            }
            
        }
        
        return Arrays.asList(critical,pseudo );
        
    }
    
    private int findCost(int[][]  edges, int n, int[] pick, int[] skip){
        
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        
        if(pick !=null){
            uf.union(pick[0], pick[1]);
            cost += pick[2]; 
        }
        
        for(int[] edge : edges){
            
            if(skip != edge && uf.union(edge[0], edge[1])){
                cost += edge[2];
            }
            
        }
        
        return uf.count == 1 ? cost : Integer.MAX_VALUE;
        
        
    }
    
   static class UnionFind{
       
       int[] parents;
       int count;

        
       public UnionFind(int n){
          
           parents = new int[n];
           count = n;
           reset();
       }
       public void reset(){
           for(int i=0; i<parents.length; i++){
               parents[i] = i;
           }
          
       }
       public int find(int i){
           
           if(parents[i]!=i){
               parents[i] = find(parents[i]);
           }
           return parents[i];
       }
       
       
       public boolean union(int i1, int i2){
           int n1 = find(i1);
           int n2 = find(i2);
           
           if(n1 !=n2){
              
               parents[n2] = n1;
               count--;
               return true;
               
           }else{
               return false;
           }
       }
        
    }
}