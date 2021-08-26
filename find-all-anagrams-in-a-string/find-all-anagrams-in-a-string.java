class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(char c : p.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        
        int start = 0, matched =0; 
        
        for(int end = 0; end< s.length(); end++){
            
            char ch = s.charAt(end);
            
            if(map.containsKey(ch)){
                
                map.put(ch, map.get(ch)-1);
                
                if(map.get(ch) == 0){
                    
                    matched++;
                }
                
            if(matched == map.size()){
                    res.add(start);
            }
           
            }
              
        
            if(end - start + 1 == p.length()){
                
                char w = s.charAt(start++);
                
                if(map.containsKey(w))
               { 
                    if(map.get(w) ==0){
                        matched--;
                    } 
                     map.put(w, map.get(w) + 1);
                }
                
            }
            
            
        }
        return res;
        
        
    }
}