class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
      return dfs(s,0, new Boolean[s.length()], wordDict);
        
    }
    
    public boolean dfs(String s, int i, Boolean[] memo, List<String> wordDict){
        
        if(s==null || s.length()==0 || wordDict==null || wordDict.size()==0 || i==s.length()){
            
            return true;
        }
           
     
        if(memo[i]!=null){
            return memo[i];
        }
        
         boolean found = false;
        
        for(String word : wordDict){
            
            if(s.substring(i).startsWith(word)){
                    found = found || dfs(s, i+ word.length(), memo,wordDict);
                }
                
            }
        
    
        memo[i] = found;
        
        return found;
    }
}