class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        
        Queue<String> queue = new LinkedList<>();

        Set<String> words = new HashSet<>(wordList);
        
        queue.offer(beginWord);
        words.remove(beginWord);
        int level = 0;
        
        while(!queue.isEmpty()){
            
            level++;
            
            for(int i = queue.size(); i>0; i--){
                
                String word = queue.poll();
                
                if(endWord.equals(word)){
                    return level;
                }
                for(String newWord : getNeighbour(word)){
                    
                    if(words.contains(newWord)){
                        queue.offer(newWord);
                        words.remove(newWord);
                        
                    }
                }
                
                
                
            }
        }
        
        return 0;
    }
    
   private List<String> getNeighbour(String word){
       
       List<String>  res = new LinkedList<>();
       
       for(int j = 0; j<word.length(); j++){
             char[] ch = word.toCharArray();
           for(char i='a'; i<='z'; i++){
            
              ch[j] = i;
              res.add(new String(ch)); 
            }
           
       }
       
       return res;
       
   }
}