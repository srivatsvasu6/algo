class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        
        if(isConnected==null || isConnected.length ==0)
            return 0;
        int count = 0;
        int[] visited = new int[isConnected.length];
        for(int i=0; i<isConnected.length; i++){
            
            if(visited[i]==0){
                
                dfs(isConnected, visited, i);
                count++;
            }
        }
    
        return count;
        
    }
    
    public void dfs(int[][] isConnected,   int[] visited, int i){
        
        if(visited[i]==1){
            return;
        }
        
        visited[i] = 1;
       for(int J=0; J<isConnected.length; J++){
            
            
            if(visited[J]==0 && isConnected[i][J]==1){
                
                dfs(isConnected, visited, J);
             
            }
        }
    }
}