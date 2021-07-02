class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[s.length()];
        
        while(!q.isEmpty()){
            
            int curr = q.poll();
              if(!visited[curr]){ 
            for(int end = curr+1; end<= s.length(); end++){
             
                    if(set.contains(s.substring(curr, end))){
                        q.offer(end);
                        
                        if(end== s.length()){
                            return true;
                        }
                    }
                    
                    
                }
                
              visited[curr]=true;  
            }
        }
        
        return false;
    }
}