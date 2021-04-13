class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character,Integer> charFreqMap = new HashMap<>();
        int start = 0, max=0, maxRepeat=0;
        
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
        
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch,0)+1);
            
            maxRepeat = Math.max(maxRepeat,charFreqMap.get(ch));
            
            if(i - start + 1 - maxRepeat > k){
                
                char first = s.charAt(start++);
              
                charFreqMap.put(first, charFreqMap.get(first) -1);
                
            
            }
            
            max = Math.max(max, i+1 - start);

            
        }
        return max;
        
    }
}