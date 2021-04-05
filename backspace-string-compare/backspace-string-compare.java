class Solution {
    public boolean backspaceCompare(String S, String T) {
     
        int sh = S.length();
        int th = T.length();
        
        int skS=0, skT=0;
        
    int i = sh-1, j = th-1;
        
        while(i >=0 || j >=0 ){
            
            
    
        while(i >=0){
            
            if(S.charAt(i) == '#'){
                skS++; i--;
            
            }else if(skS > 0){
                skS --;
                i--;
            }else
                break;
             
        }
         while(j >=0){
            
            if(T.charAt(j) == '#'){
                skT++; j--;
            
            }else if(skT > 0){
                skT --;
                j--;
            }else
                break;
             
        }
            
            
        if(i>=0 && j>=0 && S.charAt(i)!=T.charAt(j)){
            return false;
        }

        if(i >=0 != j>=0) 
            return false;
          
         i--; j--;   
            
            
            
        }
        return true;
        
    }
}