class Solution {
    public int countPalindromicSubsequence(String s) {
       
        
        Set<Character> left = new HashSet<>();
        Set<String> res = new HashSet<>();
        Map<Character, Integer> right = new HashMap<>();
        
        for(char c: s.toCharArray()){
            right.put(c, right.getOrDefault(c,0)+1);
        }
        
        for(char c : s.toCharArray()){
    
          
            right.put(c, right.get(c)-1);
            
            if(right.get(c) == 0){
                right.remove(c);
            }
            
            for(char j = 'a' ; j<='z'; j++){
                
                if(left.contains(j) && right.containsKey(j)){
                   StringBuilder sb = new StringBuilder();
                    sb.append(j);
                    sb.append(c);
                    res.add(sb.toString());
                }
            }
            
            left.add(c);
            
        }
        
        return res.size();
    }
}