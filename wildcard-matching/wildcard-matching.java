class Solution {
    public boolean isMatch(String s, String p) {
        
        int sIdx = 0, pIdx = 0, sLen = s.length(), match = 0, startIdx =-1;
        
        
        while(sIdx < sLen){
            
            
            if( pIdx< p.length() && (p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx) =='?' )){
            sIdx++;
            pIdx++;    
                
                
            }
            else if(pIdx< p.length() && p.charAt(pIdx) =='*'){
                startIdx = pIdx;
                match = sIdx;
                pIdx++;
            }else if(startIdx != -1){
                
                pIdx = startIdx + 1;
                match++;
                sIdx = match;
            }else
                return false;
        }
        
        
        while(pIdx< p.length() && p.charAt(pIdx)=='*'){
            pIdx++;
        }
        
        return pIdx == p.length();
    }
}