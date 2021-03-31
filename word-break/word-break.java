class Solution {
    
    Set<String> visited = new HashSet();
public boolean wordBreak(String s, List<String> wordDict) {

    if(visited.contains(s)){
        return false;
    }
    
    for (int i = 1; i <= s.length(); ++i) {
      String first = s.substring(0, i);
      if (wordDict.contains(first)) {
        String second = s.substring(i);
     
        if (second == null || second.length() == 0 || wordDict.contains(second) || wordBreak(second, wordDict)) {
          return true;
        }else{
               visited.add(second);
        }

      }
    }
    visited.add(s);
    return false;
}
  
}