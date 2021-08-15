class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        
        int n = graph.length;
       List<List<Integer>> list = new ArrayList<>();
        
       List<Integer> temp = new ArrayList<>();
        temp.add(0);
        
        dfs(graph,0, temp,  list);
        return list;
    }
    
    public void dfs( int[][] graph,  int source,  List<Integer> temp,  List<List<Integer>> list ){
         int target = graph.length -1;
      
        
        
        if(source == target){
          
            list.add(new ArrayList<>(temp));
         
        }else{
            
            for(Integer node : graph[source] ){
                temp.add(node);
                dfs(graph,node, temp, list);
                temp.remove(temp.size()-1);
                
            }
        }
    }
}