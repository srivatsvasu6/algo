class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
    Trie trie= new Trie();
        
        for(String word: words){
            trie.insert(word);
        }
       Set<String>  res = new HashSet<>(); 
    
        
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[i].length; j++){
                
             dfs(board, "",trie,i, j, res);
            }
        }
       
        return new ArrayList<>(res);
        
    }
    
    public void dfs(char[][] board, String str,  Trie trie, int i, int j, Set<String>  res){
        
        int m = board.length;
        int n = board[0].length;
        
        if(i<0 || j<0|| i>=m || j>=n || board[i][j]=='#')
            return;
       
        char ch = board[i][j];
        
        
        str += ch;
        
        if (!trie.startsWith(str)) return;
        
        if (trie.search(str)) {
            res.add(str);
        }
        
        board[i][j] = '#';
        dfs(board, str,trie, i - 1, j, res);
        dfs(board, str,trie, i + 1, j, res);
        dfs(board, str,trie, i, j - 1, res);
        dfs(board, str,trie, i, j + 1, res);
        board[i][j] = ch;
        
    }
    
    
    
}

class Trie{
    
    public TrieNode root;
    
    public Trie(){
        root = new TrieNode();
        
    }
    
    public void insert(String word){
        TrieNode node = root;
        for(int i =0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
            
        }
        node.setEnd();
        
    }
    
    public boolean search(String word) {
       TrieNode node = searchPrefix(word);
      
        return node != null && node.isEnd();
        
    }
    
    public boolean startsWith(String word){
        TrieNode node = searchPrefix(word);
      
        return node != null;
    }
    
    public TrieNode searchPrefix(String word){
        
        TrieNode node = root;
        
        for(int i =0; i<word.length(); i++ ){
            
            char ch = word.charAt(i);
            
            if(node.containsKey(ch)){
                node = node.get(ch);
            }else{
                return null;
            }
            
        }
        return node;
    }
    
    
}

class TrieNode{
    
    private TrieNode[] child;
    private boolean end;
    
    public TrieNode(){
        child = new TrieNode[26];
    }
    
    public boolean containsKey(char ch){
        return child[ch-'a'] !=null;
    }
    
    public TrieNode get(char ch){
        return child[ch -'a'];
    }
    
    public void put(char ch, TrieNode node){
        child[ch-'a'] = node;
    }
    
    public boolean isEnd(){
        return end;
    }
    
    public void setEnd(){
        end = true;
    }
}