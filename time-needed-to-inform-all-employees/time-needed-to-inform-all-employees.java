class Solution {
    int res = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            if(manager[i]!=-1)
        {   
              List<Integer> ls =   map.getOrDefault(manager[i], new ArrayList<>());
                ls.add(i);
                map.put(manager[i],ls);
        }
        }
        
        
        dfs(map,informTime, headID, 0);
        
        return res;
        
    }
    
    public void dfs(  Map<Integer, List<Integer>> map, int[] informTime, int i, int curr )       {
       
        
        curr += informTime[i];
        res = Math.max(res, curr);
        
        if(map.get(i)==null)
            return;
        
        for(Integer node: map.get(i)){
             dfs(map,informTime, node, curr );
        }
        
   
    }
}