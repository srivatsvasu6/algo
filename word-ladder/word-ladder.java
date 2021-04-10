class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      
        char[] ALPHABETS = new char[26];
        
        for(int i=0 ; i<26; i++ ){
           ALPHABETS[i] =  (char) (i + 'a');
        }
        Set<String> words = new HashSet(wordList);
        int length = 0;
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(beginWord);
        
        while(!queue.isEmpty()){
            
            int n = queue.size();
            length++;
            for(int i=0; i<n; i++)
            
           { 
                String word = queue.poll();
          
                for(int j=0; j< word.length(); j++){
                    
                  for(char c: ALPHABETS ){
                      
                      StringBuilder sb = new StringBuilder(word.length());
                      sb.append(word.substring(0, j));
                      sb.append(c);
                      sb.append(word.substring(j+1));
                      
                      String newWord = sb.toString();
                      if(!words.contains(newWord))
                          continue;
                      
                      if(newWord.equals(endWord))
                          return length+1;
                      
                      queue.offer(newWord);
                     
                      words.remove(newWord);
                     
                  }
                    
                    
                    
                }
           
           }
            
            
            
           
            
        }
        
        return 0;
        
        
    }
}