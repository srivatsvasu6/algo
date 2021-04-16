class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> freq = new HashMap<>();
        for(int i=0; i< p.length(); i++){
            freq.put(p.charAt(i), freq.getOrDefault(p.charAt(i),0)+1);
        }
        
        int start =0, matched =0;
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            
            
            char ch = s.charAt(i);
                        
            if(freq.containsKey(ch)){
                
                freq.put(ch, freq.get(ch)-1);
                
                
                if(freq.get(ch)==0){
                    matched++;
                }
            }
            
            if(freq.size()==matched){
                res.add(start);
                   
            }
            
            
            if( i >= p.length()  -1){
                
                char fs = s.charAt(start++);
                if(freq.containsKey(fs))
               { 
                   
                    
                    if(freq.get(fs)==0){
                    matched--;
                    }
                    
                     freq.put(fs, freq.get(fs)+1);
                    
                
                }
                
            }
            
            
        }
        
        return res;
        
    }
}