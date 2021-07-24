class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
    TrieNode trie= buildTrie(words);
        
       List<String>  res = new ArrayList<>(); 
    
        
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[i].length; j++){
                
             dfs(board, i, j, trie, res);
            }
        }
       
        return new ArrayList<>(res);
        
    }
    
    public TrieNode buildTrie(String[] words){
        TrieNode root =new TrieNode();
        
        for(String word: words){
            TrieNode p = root;
            for(char c: word.toCharArray()){
                
                int idx = c - 'a';
                
                if(p.next[idx]==null){
                    p.next[idx] = new TrieNode();
                  
                }
                  p = p.next[idx];
            }
            p.word = word;
            
            
        }
        return root;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
    char c = board[i][j];
    if (c == '#' || p.next[c - 'a'] == null) return;
    p = p.next[c - 'a'];
    if (p.word != null) {   // found one
        res.add(p.word);
        p.word = null;     // de-duplicate
    }

    board[i][j] = '#';
    if (i > 0) dfs(board, i - 1, j ,p, res); 
    if (j > 0) dfs(board, i, j - 1, p, res);
    if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
    if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
    board[i][j] = c;
}
    
    
    
}



class TrieNode{
    
     TrieNode[] next;
     String word; 
    
    public TrieNode(){
        next = new TrieNode[26];
    }
  
}