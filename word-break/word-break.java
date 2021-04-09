class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs( 0, new Boolean[s.length()], s, wordDict);
    }
    
    public boolean dfs(int i, Boolean[] memo, String s, List<String> wordDict)         {
        
      if(s.length()==i){
          return true;
      }
        if(memo[i]!=null){
            return memo[i];
        }
         boolean found = false;
        
        for(String word: wordDict ){
           
           if(s.substring(i).startsWith(word)){
               found = found || dfs(i+ word.length(), memo,s,wordDict);
           }
        }
        memo[i] = found;
        
        return found;
        
        
    }
}