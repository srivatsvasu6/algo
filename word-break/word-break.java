class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] valid = new boolean[len];
        
        for(int left = 0; left<len; left++){
            
            for(int right = left; right < len; right++){
                
                if( dict.contains(s.substring(left, right+1)) && 
                                  (left == 0 || valid[left-1])) {
                    valid[right] = true;
                    
                   
                }
                    
                }
      }
        
                   
    return valid[len -1];
    }
}