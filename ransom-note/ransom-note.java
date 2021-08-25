class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
      int[] dict = new int[26];
        
        for(char c: magazine.toCharArray()){
            dict[c - 'a'] ++;
        }
        
         for(char c: ransomNote.toCharArray()){
            if(dict[c - 'a'] <= 0){
                return false;
            }
             dict[c - 'a']--;
             
        }
        
      
        
        return true;
    }
}