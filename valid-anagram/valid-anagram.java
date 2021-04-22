class Solution {
    public boolean isAnagram(String s, String t) {
        
        int matched = 0;
        if(s==null && t==null){
            return true;
        }
        if(s==null || t==null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        
        if(s==t || s.equals(t)){
            return true;
        }
        
      List<Character> ls = new ArrayList<>();
        
        for(char ch: s.toCharArray()){
            
            ls.add(ch);
        }
        
        for(char ch: t.toCharArray()){
             
              ls.remove(Character.valueOf(ch));
            
        }
        
       
        return ls.isEmpty();
    }
}