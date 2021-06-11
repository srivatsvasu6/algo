class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        int j = 0, max = 0;
        
    for(int i = 0; i<s.length(); i++){
        
        char c = s.charAt(i);
        
        if(map.containsKey(c)){
            
            j = Math.max(j, map.get(c));
            
        }
        
       max = Math.max(max, i - j +1);
        map.put(c, i+1);
                          
        
    }
        
    
        return max;
    }
}